package com.sherlock.baseandroid.lesson4;


import android.os.Bundle;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    static final String NameSharedPreference = "LOGIN";
    final String appTheme = "APP_THEME";
    final int MyCoolCodeStyle = 0;
    final int AppThemeLightCodeStyle = 1;
    final int AppThemeCodeStyle = 2;
    final int AppThemeDarkCodeStyle = 3;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyColorStyle));
    }

    private int getAppTheme(int codeStyle){
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case AppThemeCodeStyle:
                return R.style.AppTheme;
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.MyColorStyle;
        }
    }

    //Чтение настроек, параметр Тема
    int getCodeStyle(int codeStyle){
        //Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(appTheme, codeStyle);
    }

    //сохранение настроек
    void setAppTheme(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //настройки сохраняются посредством специального класса editor
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme,codeStyle);
        editor.apply();
    }

}
