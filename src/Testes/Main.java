package Testes;

import java.util.ArrayList;
import java.util.List;

import Logica.Controlador;
 
import easyaccept.EasyAcceptFacade;
 
public class Main {
 
        public static void main(String[] args) throws Exception {
             
              List<String> files = new ArrayList<String>();
              //Put the us1.txt file into the "test scripts" list
              //files.add("US01.txt");
              files.add("US02.txt");
             // files.add("US03.txt");
  //Instantiate the Monopoly Game façade
              Controlador facade = new Controlador();
              //Instantiate EasyAccept façade
              EasyAcceptFacade eaFacade = new EasyAcceptFacade(facade, files);
  //Execute the tests
              eaFacade.executeTests();
  //Print the tests execution results
              System.out.println(eaFacade.getCompleteResults());
        }
}
