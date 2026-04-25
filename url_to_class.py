#!/usr/bin/env python3
import sys
import os
import re
import pyperclip

def convert_to_pascal_case(text):
    # Replace hyphens with spaces
    text = text.replace('-', ' ')
    # Capitalize each word and join them without spaces
    return ''.join(word.capitalize() for word in text.split())

def extract_class_name_from_url(url):
    # Extract the relevant part from the URL using regex
    match = re.search(r'/([^/]+)/[^/]+$', url)
    if match:
        # Get the part before the last slash
        return convert_to_pascal_case(match.group(1))
    return None

def is_valid_codetree_url(url):
    return url.startswith('https://www.codetree.ai/') and url.endswith('/description')

def format_number(num):
    # Convert number to string and pad with leading zeros
    return f"{int(num):02d}"

def extract_trail_info_from_url(url):
    """Extract trail, chapter, lesson numbers from URL path segments."""
    # URL pattern: .../trails/complete/curated-cards/intro-print-word/description
    # We don't extract numbers from URL; they are provided as arguments or not needed
    pass

def confirm_overwrite(file_path):
    if not os.path.exists(file_path):
        return True
    response = input(f"File already exists: {file_path}\nOverwrite? (y/n): ").strip().lower()
    return response == 'y'

def create_java_class(package_name, package_dir, class_name, url):
    # Ensure the directory exists
    os.makedirs(package_dir, exist_ok=True)

    # Create the file path
    java_file = os.path.join(package_dir, f"{class_name}.java")

    if not confirm_overwrite(java_file):
        print("Aborted.")
        return

    # Write the Java class file
    with open(java_file, 'w') as f:
        f.write(f"package {package_name};\n\n")
        f.write("import java.io.BufferedReader;\n")
        f.write("import java.io.BufferedWriter;\n")
        f.write("import java.io.IOException;\n")
        f.write("import java.io.InputStreamReader;\n")
        f.write("import java.io.OutputStreamWriter;\n")
        f.write("import java.util.StringTokenizer;\n\n")
        f.write(f"/**\n * @see <a href=\"{url}\">LINK</a>\n */\n")
        f.write(f"public class {class_name} {{\n\n")
        f.write("  private static BufferedReader br;\n")
        f.write("  private static BufferedWriter bw;\n")
        f.write("  private static StringTokenizer st;\n\n")
        f.write("  public static void main(String[] args) throws IOException {\n")
        f.write("    br = new BufferedReader(new InputStreamReader(System.in));\n")
        f.write("    bw = new BufferedWriter(new OutputStreamWriter(System.out));\n")
        f.write("    \n\n")
        f.write("    br.close();\n")
        f.write("    bw.close();\n")
        f.write("  }\n")
        f.write("}\n")

    print(f"Created Java class at: {java_file}")

def create_kotlin_class(package_name, package_dir, class_name, url):
    # Ensure the directory exists
    os.makedirs(package_dir, exist_ok=True)

    # Create the file path
    kotlin_file = os.path.join(package_dir, f"{class_name}.kt")

    if not confirm_overwrite(kotlin_file):
        print("Aborted.")
        return

    # Per-file sub-package (camelCase) to isolate top-level private classes
    # across files in the same directory. Kotlin allows package != directory.
    kotlin_package = f"{package_name}.{class_name[0].lower()}{class_name[1:]}"

    # Write the Kotlin class file
    with open(kotlin_file, 'w') as f:
        f.write(f"package {kotlin_package}\n\n")
        f.write("import java.io.BufferedReader\n")
        f.write("import java.io.BufferedWriter\n")
        f.write("import java.io.InputStreamReader\n")
        f.write("import java.io.OutputStreamWriter\n")
        f.write("import java.util.StringTokenizer\n\n")
        f.write("private val br = BufferedReader(InputStreamReader(System.`in`))\n")
        f.write("private val bw = BufferedWriter(OutputStreamWriter(System.out))\n\n")
        f.write(f"/**\n * @see <a href=\"{url}\">LINK</a>\n */\n")
        f.write("fun main() {\n")
        f.write("\n")
        f.write("    bw.flush()\n")
        f.write("}\n\n")
        f.write("private fun parseInts() =\n")
        f.write("    StringTokenizer(br.readLine()).run {\n")
        f.write("        IntArray(countTokens()) {\n")
        f.write("            nextToken().toInt()\n")
        f.write("        }\n")
        f.write("    }\n")

    print(f"Created Kotlin class at: {kotlin_file}")

def main():
    if len(sys.argv) != 5:
        print("Usage: python url_to_class.py <java|kotlin> <trail_number> <chapter_number> <lesson_number>")
        print("  The CodeTree URL should be copied to clipboard.")
        sys.exit(1)

    lang = sys.argv[1].lower()
    trail_num = sys.argv[2]
    chapter_num = sys.argv[3]
    lesson_num = sys.argv[4]
    url = pyperclip.paste().strip()

    if not is_valid_codetree_url(url):
        print("Error: Clipboard does not contain a valid CodeTree URL")
        sys.exit(1)

    class_name = extract_class_name_from_url(url)
    if not class_name:
        print(f"Could not extract class name from URL: {url}")
        sys.exit(1)

    package_name = f"org.dukcode.ps.codetree.trail{format_number(trail_num)}.chapter{format_number(chapter_num)}.lesson{format_number(lesson_num)}"

    if lang == 'java':
        package_dir = os.path.join("src", "main", "java", *package_name.split("."))
        create_java_class(package_name, package_dir, class_name, url)
    elif lang == 'kotlin':
        package_dir = os.path.join("src", "main", "kotlin", *package_name.split("."))
        create_kotlin_class(package_name, package_dir, class_name, url)
    else:
        print(f"Error: Unsupported language '{lang}'. Use 'java' or 'kotlin'.")
        sys.exit(1)

if __name__ == "__main__":
    main() 