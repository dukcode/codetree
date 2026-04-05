#!/usr/bin/env python3
import sys
import os
import re
import subprocess


def find_new_or_modified_files():
    """Find untracked or modified files under src/."""
    result = subprocess.run(
        ["git", "status", "--porcelain", "-u", "src/"],
        capture_output=True, text=True
    )
    files = []
    for line in result.stdout.strip().splitlines():
        if not line:
            continue
        # status is first 2 chars, then space, then path
        status = line[:2].strip()
        path = line[3:]
        if status in ("??", "A", "M", "AM"):
            files.append(path)
    return files


def extract_trail_number(path):
    """Extract trail number from path like .../trail06/..."""
    match = re.search(r'trail(\d+)', path)
    if match:
        return int(match.group(1))
    return None


def extract_class_name(path):
    """Extract class name from file path (filename without extension)."""
    basename = os.path.basename(path)
    name, _ = os.path.splitext(basename)
    return name


def main():
    files = find_new_or_modified_files()

    if not files:
        print("Error: No new or modified files found under src/.")
        sys.exit(1)

    # Filter to only source files
    source_files = [f for f in files if f.endswith(('.java', '.kt'))]

    if not source_files:
        print("Error: No .java or .kt files found among changes.")
        sys.exit(1)

    if len(source_files) > 1:
        print("Warning: Multiple changed files found:")
        for f in source_files:
            print(f"  {f}")
        print(f"Using: {source_files[0]}")

    target_file = source_files[0]
    trail_num = extract_trail_number(target_file)
    class_name = extract_class_name(target_file)

    if trail_num is None:
        print(f"Error: Could not extract trail number from: {target_file}")
        sys.exit(1)

    commit_msg = f"trail{trail_num}: {class_name}"

    print(f"File: {target_file}")
    print(f"Commit message: {commit_msg}")
    print()

    # Stage, commit, push
    subprocess.run(["git", "add", target_file], check=True)
    subprocess.run(["git", "commit", "-m", commit_msg], check=True)
    subprocess.run(["git", "push"], check=True)

    print(f"\nDone! Committed and pushed: {commit_msg}")


if __name__ == "__main__":
    main()