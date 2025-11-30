package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import org.dukcode.psutils.PSTest;
import org.dukcode.psutils.PSTestCase;
import org.dukcode.psutils.PSTestCases;

@PSTest(solution = ChallengeHeightOfFriends4.class)
class ChallengeHeightOfFriends4Test {

  @PSTestCases({
      @PSTestCase(
          input = """
              5 5
              3 2
              1 5
              2 1
              3 4
              4 2
              """,
          output = """
              Consistent
              """
      ),
  })
  void test() {
  }

}