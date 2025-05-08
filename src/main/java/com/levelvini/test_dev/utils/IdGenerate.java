package com.levelvini.test_dev.utils;

import java.util.UUID;

public class IdGenerate{
    public static String idGenerate(){
        return UUID.randomUUID().toString();
    }
}
