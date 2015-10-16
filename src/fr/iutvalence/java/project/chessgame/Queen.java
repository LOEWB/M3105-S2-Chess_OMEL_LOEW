package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de reine
 */
public class Queen extends AbstractPiece
{

      /**
       * La liste des différentes positions possible terme de coordonnées
       */
      private final int[][] listPosition = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

      /**
       * Créer une reine de couleur donnée
       *
       * @param couleur La couleur de la reine
       */
      public Queen(ColorEnum couleur)
      {
            super(couleur);
            this.Piecetype = PieceType.QUEEN;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_QUEEN;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_QUEEN;
            }
      }

      /**
       * Détermine les différents movements possible à partir d'une position de
       * départ donnée
       *
       * @param positionDepart La position actuelle de la pièce
       * @return Une liste de tout les déplacements possible à partir d'une
       *         position
       */
      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Square positionDeFin;
            Position newPosition;
            int i, j;
            for (int[] direction : listPosition)
            {
                  for (int compteurDirection = 1; compteurDirection < 8; compteurDirection++)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0] * compteurDirection;
                        j = positionDepart.obtenirNumeroDeColonne() + direction[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                        {
                              positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                              if (positionDeFin.getPiece() != null)
                              {
                                    if (positionDeFin.getPiece().obtenirCouleur() == this.couleur)
                                    {
                                          break;
                                    }
                                    possibleMovement.add(newPosition);
                                    break;
                              }
                              else
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }
                  }
            }
            return possibleMovement;
      }

      /**
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString()
      {
            return "r" + super.toString();
      }

}
