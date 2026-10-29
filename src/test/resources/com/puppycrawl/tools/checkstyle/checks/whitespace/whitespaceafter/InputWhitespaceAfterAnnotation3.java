/*
WhitespaceAfter
tokens = ANNOTATIONS


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.whitespaceafter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class InputWhitespaceAfterAnnotation3 {
    @Target(ElementType.TYPE_USE)
    @interface First {}

    @Target(ElementType.TYPE_USE)
    @interface Second {}

    @Target(ElementType.TYPE_USE)
    @interface Size {
        int max();
    }

    void ellipsisValid(String @First @Second ... args) {}

    void ellipsisInvalid(String @First @Second... args) {}
    // violation above ''Second' is not followed by whitespace'

    void ellipsisWithParens(String @First @Size(max = 1)... args) {}
    // violation above '')' is not followed by whitespace'

    void ellipsisQualified(String @First @InputWhitespaceAfterAnnotation3.Second... args) {}
    // violation above ''Second' is not followed by whitespace'

    void ellipsisAfterArray(String @First @Second []... args) {}

    String @First @Second [] arrayValid;

    String @First @Second[] arrayInvalid;
    // violation above ''Second' is not followed by whitespace'

    String @First@Second [] noSpaceBetween;
    // violation above ''First' is not followed by whitespace'

    String @First@Second[] noSpaceAnywhere;
    // 2 violations above:
    //   ''First' is not followed by whitespace'
    //   ''Second' is not followed by whitespace'

    int @First [] @First @Second[] nestedDimension;
    // violation above ''Second' is not followed by whitespace'
}
