package com.darknamer.app;

import com.darknamer.data.services.generators.GenerateFakerService;
import com.darknamer.core.interfaces.IGenerateFakerService;

public class App {
    public static void main(String[] args) {
        IGenerateFakerService generateFakerService = new GenerateFakerService();
        generateFakerService.Generate();
    }
}
