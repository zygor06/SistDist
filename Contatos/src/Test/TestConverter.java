package Test;

import Util.Converter;

public class TestConverter {

    public static void main(String[] args){

        Converter c = new Converter();
        System.out.println(c.toRoman(19));
        System.out.println(c.toNumerical("XXXIVL"));

    }
}
