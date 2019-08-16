package com.puzzles.io;

import com.puzzles.commands.CommandDispatcher;
import com.puzzles.commands.CommandMove;
import com.puzzles.tables.*;

import java.util.Scanner;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class Main {

    public Main() {
        test1();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void test1() {
        Scanner in = new Scanner(System.in);

        System.out.println("enter dimension and start position: ");
        String messsage_init = in.nextLine();
        System.out.println("You entered dimension and start position: " + messsage_init.trim());

        //int[] values_init = new int[4];
        int[] values_init = new int[0];
        try {
            values_init = Arrays.stream(messsage_init.trim().split(",")).filter(x -> x!=null && x.length() > 0)
                    .peek(System.out::println)
                    .mapToInt(Short::parseShort)
                    .toArray();
        } catch (Exception e) {
        }

        while (values_init.length != 4) {
            System.out.println("Invalid data! Enter dimension and start position: ");
            messsage_init = in.nextLine();
            System.out.println("You entered dimension and start position: " + messsage_init.trim());
            try {
                values_init = Arrays.stream(messsage_init.trim().split(",")).filter(x -> x!=null && x.length() > 0)
                        .peek(System.out::println)
                        .mapToInt(Short::parseShort)
                        .toArray();
                System.out.println("You entered arr lenght: " + values_init.length);

            } catch (Exception e) {
            }

        }
        System.out.println("You entered arr: " + values_init.toString());

        System.out.println("enter moves:");
        String messsage_moves = in.nextLine();
        System.out.println("You entered moves " + messsage_moves.trim());

        int[] values_moves = new int[1];

        try {
            values_moves = Arrays.stream(messsage_moves.trim().split(",")).filter(x -> x != null && x.length() > 0)
                    .peek(System.out::println)
                    .mapToInt(Byte::parseByte)
                    .toArray();
            System.out.println("You entered arr lenght: " + values_moves.length);

        } catch (Exception e) {
        }

        in.close();

        GridShape table2D = new Table2D(values_init[0], values_init[1]);
        Location location = new Location(values_init[2], values_init[3]);
        GridState gridState = null;

        try{
            gridState = new GridState(location, table2D);
        }catch(Location.LocationAccessException e){
            System.out.println(e.getMessage());
            System.out.println("-1,-1");
            System.exit(-1);
        }

        int i, x;
        CommandMove commandMove;
        CommandDispatcher commandDispatcher = new CommandDispatcher();
        for (i = 0; i < values_moves.length; i++) {
            commandMove = CommandMove.getFromIndexNumber(values_moves[i]);
            commandDispatcher.registerHandler(commandMove);
            System.out.print(commandMove + " ");
        }

        GridState finalGridState = gridState;
        CompletableFuture.supplyAsync(() ->  commandDispatcher.invokeCommands(finalGridState));

        try{
             sleep(1000);
        }catch(Exception e){
        }

        System.out.println("final location");
        System.out.println("Point X is " + finalGridState.getLocation().getPointX());
        System.out.println("Point Y is " + finalGridState.getLocation().getPointY());
    }
}
