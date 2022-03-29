package com.apcs.unit9.overwritingMethods;

public class Main {
    public static void main(String[] args) {
        BoringEmployee boringEmployee = new BoringEmployee(1, 10.00, "Boring");

        boringEmployee.work(8);
        boringEmployee.getPaid();
        System.out.println(boringEmployee);
        System.out.println();
        
        Cooper cooper = new Cooper(15, "Cooper", 89, "CooperRecob");

        cooper.playCoC(8);
        cooper.beCool();
        System.out.println(cooper);
        System.out.println();

        CoCPlayer cocPlayer = new CoCPlayer(15, "Cooper", 89, "CooperRecob");
        
        cocPlayer.playCoC(8);
        cocPlayer.beCool();
        System.out.println(cocPlayer);
    }
}