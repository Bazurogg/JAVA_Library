package fr.pompey.dev.afpa;


import fr.pompey.dev.afpa.controller.LibController;
import fr.pompey.dev.afpa.model.Library;

import java.util.Date;

public class Main {

    Library library = new Library();
    LibController controller = new LibController(library);

}