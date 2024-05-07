package com.jovisco.basics.strings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WorkWithStringsTest {

    @Test
    void testStringTemplate() {
        final String bla = "BLA BLA";

        var text = "Alles, was ich so sage ist nur ${bla}. Bei euch ist es leider ebenso.";
        System.out.println(text);
        System.out.flush();
        // string template is only PREVIEW in Java 21 -> so it won't work here
        assertThat(text).doesNotContain(bla);
    }


}
