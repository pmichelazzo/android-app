package fr.gaulupeau.apps.Poche.ui;

import android.app.Activity;

import fr.gaulupeau.apps.InThePoche.R;
import fr.gaulupeau.apps.Poche.App;

public class Themes {

    private static Theme theme;

    static {
        init();
    }

    public static void init() {
        Themes.theme = App.getInstance().getSettings().getTheme();
    }

    public static Theme getCurrentTheme() {
        return theme;
    }

    public static void applyTheme(Activity activity) {
        activity.setTheme(theme.getResId());
    }

    public static void applyProxyTheme(Activity activity) {
        activity.setTheme(theme.getProxyResId());
    }

    public enum Theme {
        Light(
                R.string.themeName_light,
                R.style.LightTheme,
                R.style.ProxyTheme
        ),

        LightContrast(
                R.string.themeName_light_contrast,
                R.style.LightThemeContrast,
                R.style.ProxyTheme
        ),

        Dark(
                R.string.themeName_dark,
                R.style.DarkTheme,
                R.style.ProxyThemeDark
        ),

        DarkContrast(
                R.string.themeName_dark_contrast,
                R.style.DarkThemeContrast,
                R.style.ProxyThemeDark
        ),

        Solarized(
                R.string.themeName_solarized,
                R.style.SolarizedTheme,
                R.style.ProxyTheme
        );

        private int nameId;
        private int resId;
        private int proxyResId;

        Theme(int nameId, int resId, int dialogResId) {
            this.nameId = nameId;
            this.resId = resId;
            this.proxyResId = dialogResId;
        }

        public int getNameId() {
            return nameId;
        }

        public int getResId() {
            return resId;
        }

        public int getProxyResId() {
            return proxyResId;
        }

    }

}
