package fr.iutvalence.java.project.chessgame;


import java.util.HashMap;
import java.util.Map;



public class Echiquier
{
      
      public static final int NOMBRE_DE_LIGNES = 8;

      public static final int NOMBRE_DE_COLONNES = 8;

      public static HashMap<Position, Square> square = new HashMap<Position, Square>();

      public static void poserPiece(Echiquier board, Position position, AbstractPiece piece)
      {
            board.obtenirCase(position).setPiece(piece);
      }

      private final King blackKing;

      private final King whiteKing;

      public Echiquier()
      {
            this.blackKing = new King(ColorEnum.BLACK);
            this.whiteKing = new King(ColorEnum.WHITE);
            this.creerEchiquier();
            this.poserPieces();
      }

      public Echiquier(String string)
      {

            this.blackKing = new King(ColorEnum.BLACK);
            this.whiteKing = new King(ColorEnum.WHITE);
            this.creerEchiquier();
      }

     
      private void creerEchiquier()
      {
            for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
            {
                  for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
                  {
                        if ((numeroDeLigne + numeroDeColonne) % 2 == 0)
                        {
                              square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(ColorEnum.WHITE));
                        }
                        else
                        {
                              square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(ColorEnum.BLACK));
                        }
                  }
            }
      }

    
      public void deplacerPiece(Position positionDepart, Position positionArrivee)
      {
            AbstractPiece pieceADeplacer = this.obtenirPiece(positionDepart);
            if (pieceADeplacer == null)
            {
                  return;
            }
            Echiquier.poserPiece(this, positionArrivee, pieceADeplacer);
            this.obtenirCase(positionDepart).removePiece();
      }

      public HashMap<Position, AbstractPiece> getAllPieces(ColorEnum Color)
      {
            HashMap<Position, AbstractPiece> pieces = new HashMap<Position, AbstractPiece>();
            for (Map.Entry<Position, Square> entry : Echiquier.square.entrySet())
            {
                  if (entry.getValue().getPiece() != null)
                  {
                        if (entry.getValue().getPiece().obtenirCouleur() == Color)
                        {
                              pieces.put(entry.getKey(), entry.getValue().getPiece());
                        }
                  }
            }
            return pieces;
      }

      public King getBlackKing()
      {
            return blackKing;
      }

      public King getWhiteKing()
      {
            return whiteKing;
      }

      private Square obtenirCase(Position position)
      {
            return square.get(position);
      }

      
      public AbstractPiece obtenirPiece(Position position)
      {
            return square.get(position).getPiece();
      }

      private void poserPieces()
      {
            Echiquier.poserPiece(this, new Position(0, 0), new ROOK(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 1), new Knight(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 2), new Bishop(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 3), new Queen(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 4), this.blackKing);
            this.blackKing.setKingPosition(new Position(0, 4));
            Echiquier.poserPiece(this, new Position(0, 5), new Bishop(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 6), new Knight(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 7), new ROOK(ColorEnum.BLACK));

            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
            {
                  Echiquier.poserPiece(this, new Position(1, numeroDeColonne), new Pawn(ColorEnum.BLACK));
                  Echiquier.poserPiece(this, new Position(6, numeroDeColonne), new Pawn(ColorEnum.WHITE));
            }

            Echiquier.poserPiece(this, new Position(7, 0), new ROOK(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 1), new Knight(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 2), new Bishop(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 3), new Queen(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 4), this.whiteKing);
            this.whiteKing.setKingPosition(new Position(7, 4));
            Echiquier.poserPiece(this, new Position(7, 5), new Bishop(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 6), new Knight(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 7), new ROOK(ColorEnum.WHITE));
      }

}
