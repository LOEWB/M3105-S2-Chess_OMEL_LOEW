package fr.iutvalence.java.project.model;


import fr.iutvalence.java.project.view.MenuGUI;


public class GameLauncher
{
      public static void main(String[] args)
      {
            MenuGUI menu = new MenuGUI();
            menu.setVisible(true);

            MenuGUI.menuGUI = menu;
      }
}
