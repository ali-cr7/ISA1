/////*
//// * Copyright (C) 2017  Danijel Askov
//// *
//// * This file is part of Expectiminimax Backgammon.
//// *
//// * Expectiminimax Backgammon is free software: you can redistribute it and/or modify
//// * it under the terms of the GNU General Public License as published by
//// * the Free Software Foundation, either version 3 of the License, or
//// * (at your option) any later version.
//// *
//// * Expectiminimax Backgammon is distributed in the hope that it will be useful,
//// * but WITHOUT ANY WARRANTY; without even the implied warranty of
//// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//// * GNU General Public License for more details.
//// *
//// * You should have received a copy of the GNU General Public License
//// * along with this program.  If not, see <https://www.gnu.org/licenses/>.
//
//
//package Throwing;
//
//
//import Logic.Movement;
//import Structure.BoardGame;
//import Structure.State;
//
//import java.time.Duration;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class ExpectiminimaxPlayer   {
//    Movement movement ;
//
//    public float expectiminimax(BoardGame node, int depth) {
//        if (Movement.checkWinState(node) || depth == 0)
//            return heuristicValue(node);
//        if (adversaryToPlay(node)) {
//            // Return value of minimum-valued child node
//            float alpha = Float.POSITIVE_INFINITY;
//            for (BoardGame child :movement.getNextOptions(node,5))
//                alpha = Math.min(alpha, expectiminimax(child, depth - 1));
//            return alpha;
//        } else if (weAreToPlay(node)) {
//            // Return value of maximum-valued child node
//            float alpha = Float.NEGATIVE_INFINITY;
//            for (BoardGame child :movement.getNextOptions(node,5))
//                alpha = Math.max(alpha, expectiminimax(child, depth - 1));
//            return alpha;
//        } else if (randomEvent(node)) {
//            // Return weighted average of all child nodes' values
//            float alpha = 0;
//            for (BoardGame child : movement.getNextOptions(node,5))
//                alpha += probability(child) * expectiminimax(child, depth - 1);
//            return alpha;
//        }
//        return 0;  // Default return value
//    }
////
////
////
//
////
////
//    private float probability(BoardGame child) {
//        return 0;
//    }
////
//    private int heuristicValue(BoardGame node) {
//        return 0;
//    }
////
////
//}