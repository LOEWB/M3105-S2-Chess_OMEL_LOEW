package fr.iutvalence.java.project.model;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import fr.iutvalence.java.project.view.GameGUI;


public class Game
{
      public static enum State
      {
            IN_PROGRESS,

            BLACK_MATES,

            WHITE_MATES,

            STALEMATE,

            DRAWN_BY_TRIPLE_REPETITION,

            DRAWN_BY_50_MOVE_RULE;
      }

      private static final long GAME_DURATION = 15 * 60 * 1000;

      public static int currentMove;

      public static List<Movement> _moves = new ArrayList<Movement>();

      public static Echiquier board;

      public static GameGUI userInterface;

      

      public static ColorEnum curPlayer;

      public static ColorEnum lastPlayer;

      private final Player blackPlayer;

      private boolean isWhiteTurn;

      private final Player whitePlayer;

      long blackTimer;

      private Timer timer;

      private long lastTimerTick;

      long whiteTimer;

      public Game()
      {
            Game.userInterface = new GameGUI(this);
            this.blackPlayer = new Player(ColorEnum.BLACK);
            this.whitePlayer = new Player(ColorEnum.WHITE);
            this.whiteTurnDisplay();
            Game.curPlayer = ColorEnum.WHITE;
            Game.lastPlayer = null;
            Game.currentMove = -1;
            Game.board = new Echiquier();
      }

      public List<Movement> get_moves()
      {
            return Game._moves;
      }

      public Echiquier getBoard()
      {
            return board;
      }

      public ColorEnum getCurPlayer()
      {
            return Game.curPlayer;
      }

      public int getCurrentMove()
      {
            return Game.currentMove;
      }

      public GameGUI getUserInterface()
      {
            return userInterface;
      }

      public boolean isEndOfGame(ColorEnum color)
      {
            if (color == ColorEnum.WHITE)
            {
                  King whiteKing = Game.board.getWhiteKing();
                  if (whiteKing.isCheck(whiteKing.getKingPosition()) && whiteKing.possibleMovements(whiteKing.getKingPosition()).isEmpty())
                  {
                        return true;
                  }
            }
            else
            {
                  King blackKing = Game.board.getBlackKing();
                  if (blackKing.isCheck(blackKing.getKingPosition()) && blackKing.possibleMovements(blackKing.getKingPosition()).isEmpty())
                  {
                        return true;
                  }
            }
            return false;
      }

      public boolean isWhiteTurn()
      {
            return isWhiteTurn;
      }

      public void blackTurnDisplay()
      {

            this.getUserInterface();
            GameGUI.joueur1.setBackground(Color.LIGHT_GRAY);
            this.getUserInterface();
            GameGUI.joueur2.setBackground(Color.WHITE);
            this.isWhiteTurn = false;
      }

      public void whiteTurnDisplay()
      {

            this.getUserInterface();
            GameGUI.joueur1.setBackground(Color.WHITE);
            this.getUserInterface();
            GameGUI.joueur2.setBackground(Color.LIGHT_GRAY);
            this.isWhiteTurn = true;
      }

     
      public void setCurPlayer(ColorEnum curPlayer)
      {
            Game.curPlayer = curPlayer;
      }

      public void setLastPlayer(ColorEnum color)
      {
            Game.lastPlayer = color;

      }

      public void setWhiteTurn(boolean isWhiteTurn)
      {
            this.isWhiteTurn = isWhiteTurn;
      }
}
