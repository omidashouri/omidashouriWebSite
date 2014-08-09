/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.omidashouri.controller;

import ir.omidashouri.entity.Theme;
import ir.omidashouri.service.theme.ThemeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ashouri
 */
@Named
@SessionScoped
public class UserPreferences implements Serializable {

    private List<String> themess;
    public List<String> getThemess() {
        return themess;
    }
    private List<Theme> themes;
    private String selectedTheme = "start";

    @Inject
    private ThemeService themeService;

    @PostConstruct
    public void init() {
        themes = themeService.getThemes();
    }

    public UserPreferences() {
        themess = new ArrayList<String>();
        themess.add("afterdark");
        themess.add("afternoon");
        themess.add("afterwork");
        themess.add("aristo");
        themess.add("black-tie");
        themess.add("blitzer");
        themess.add("bluesky");
        themess.add("bootstrap");
        themess.add("ui-darkness");
        themess.add("ui-lightness");
        themess.add("vader");
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public ThemeService getThemeService() {
        return themeService;
    }

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }
    
    public String getSelectedTheme() {
        return selectedTheme;
    }

    public void setSelectedTheme(String selectedTheme) {
        this.selectedTheme = selectedTheme;
    }

    public void saveUserTheme() {
        //logic to update the user preferred theme name in DB
        System.out.println("User Theme will be saved in data Base");
    }
}
