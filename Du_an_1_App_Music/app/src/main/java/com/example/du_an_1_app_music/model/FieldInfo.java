package com.example.du_an_1_app_music.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FieldInfo {
    String fieldName();
}
