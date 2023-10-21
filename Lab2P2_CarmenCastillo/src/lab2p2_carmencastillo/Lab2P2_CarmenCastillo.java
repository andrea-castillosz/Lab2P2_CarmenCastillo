/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_carmencastillo;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JColorChooser;

/**
 *
 * @author casti
 */
public class Lab2P2_CarmenCastillo {

    static Scanner leer = new Scanner(System.in, "ISO-8859-1");
    static Scanner leerent = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<Jugadores> jugadores = new ArrayList();
    static ArrayList<Carros> carrosSueltos = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguirmenu = true;
        while (seguirmenu) {
            System.out.println("");
            System.out.println("----MENU PRINCIPAL-----");
            System.out.println("1. Jugadores.");
            System.out.println("2. Carros.");
            System.out.println("3. Compra y Venta.");
            System.out.println("4. Salir.");
            System.out.print("Ingresar opción: ");
            int opcion = leerent.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    boolean menujugadores = true;
                    while (menujugadores) {
                        System.out.println("");
                        System.out.println("----MENU JUGADOR-----");
                        System.out.println("1. Crear Jugador.");
                        System.out.println("2. Modificar Jugador.");
                        System.out.println("3. Listar Jugadores.");
                        System.out.println("4. Eliminar Jugador.");
                        System.out.println("5. Salir.");
                        System.out.print("Ingresar opción: ");
                        int opcionjugadores = leerent.nextInt();
                        System.out.println("");

                        switch (opcionjugadores) {
                            case 1:

                                agregarJugador(jugadores);

                                break;

                            case 2:

                                modificarJugador(jugadores);

                                break;

                            case 3:

                                listarJugadores(jugadores);

                                break;

                            case 4:

                                eliminarJugador(jugadores);

                                break;

                            default:
                                menujugadores = false;
                                break;

                        }

                    }
                    break;

                case 2:
                    boolean menucarros = true;
                    while (menucarros) {
                        System.out.println("");
                        System.out.println("----MENU CARROS-----");
                        System.out.println("1. Crear Carro.");
                        System.out.println("2. Modificar Carro.");
                        System.out.println("3. Listar Carros."); //preguntar por cual jugador listar sus carros
                        System.out.println("4. Eliminar Carro.");
                        System.out.println("5. Salir.");
                        System.out.print("Ingresar opción: ");
                        int opcioncarros = leerent.nextInt();
                        System.out.println("");

                        switch (opcioncarros) {
                            case 1:

                                agregarCarro(carrosSueltos);

                                break;

                            case 2:
                                for (Jugadores j : jugadores) {
                                    System.out.println(jugadores.indexOf(j) + " -> " + j.toString());
                                }
                                System.out.print("Seleccione el jugador: ");
                                int jug = leerent.nextInt();
                                Jugadores refjugador = jugadores.get(jug);
                                modificarCarro(jugadores.get(jug).getListaCarros(), refjugador);

                                break;

                            case 3:
                                for (Jugadores j : jugadores) {
                                    System.out.println(jugadores.indexOf(j) + " -> " + j.toString());
                                }
                                System.out.print("Seleccione el jugador: ");
                                int jug2 = leerent.nextInt();
                                listarCarro(jugadores.get(jug2).getListaCarros());
                                break;

                            case 4:
                                for (Jugadores j : jugadores) {
                                    System.out.println(jugadores.indexOf(j) + " -> " + j.toString());
                                }
                                System.out.print("Seleccione el jugador: ");
                                int jug3 = leerent.nextInt();
                                eliminarCarro(jugadores.get(jug3).getListaCarros());
                                break;

                            default:
                                menucarros = false;
                                break;
                        }

                    }
                    break;

                case 3:
                    boolean compramenu = true;
                    while (compramenu) {
                        System.out.println("");
                        System.out.println("----MENU COMPRA Y VENTA-----");
                        System.out.println("1. Comprar Carro.");
                        System.out.println("2. Vender Carro.");
                        System.out.println("3. Salir.");
                        System.out.print("Ingresar opción: ");
                        int opcioncarros = leerent.nextInt();
                        System.out.println("");
                        switch (opcioncarros) {
                            case 1:
                                listarJugadores(jugadores);
                                System.out.print("Identifique que jugador va comprar: ");
                                int resp = leerent.nextInt();
                                while (resp < 0 || resp > jugadores.size() - 1) {
                                    System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
                                    resp = leerent.nextInt();
                                }

                                Jugadores ref = jugadores.get(resp);

                                listarCarro(carrosSueltos);
                                System.out.println("");
                                System.out.print("Ingrese el carro a comprar: ");
                                int respcar = leerent.nextInt();
                                while (respcar < 0 || respcar > carrosSueltos.size() - 1) {
                                    System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
                                    respcar = leerent.nextInt();
                                }

                                Carros refcar = carrosSueltos.get(respcar);

                                ref.getListaCarros().add(refcar);
                                carrosSueltos.remove(respcar);
                                ref.setCuantBanco(ref.getCuantBanco() - refcar.getPrecio());
                                System.out.println("Carro Comprado!");
                                break;

                            case 2:
                                listarJugadores(jugadores);
                                System.out.print("Identifique que jugador va vender: ");
                                int respjug = leerent.nextInt();
//                                respjug = respjug-1;
                                while (respjug < 1 || respjug > jugadores.size() - 1) {
                                    System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
                                    respjug = leerent.nextInt();
                                }

                                Jugadores refjug = jugadores.get(respjug-1);

                                listarCarro(jugadores.get(respjug).getListaCarros());
                                System.out.println("");
                                System.out.print("Ingrese el carro a vender: ");
                                int respcarro = leerent.nextInt();
                                while (respcarro < 0 || respcarro > jugadores.get(respjug).getListaCarros().size() - 1) {
                                    System.out.print("Opción fuera de rango \n Intentelo de nuevo: ");
                                    respcarro = leerent.nextInt();
                                }

                                Carros refcarro = carrosSueltos.get(respcarro - 1);

                                refjug.getListaCarros().remove(refcarro);
                                carrosSueltos.add(refcarro);
                                refjug.setCuantBanco(refjug.getCuantBanco() + refcarro.getPrecio());
                                System.out.println("Carro Vendido");
                                break;

                            default:
                                compramenu = false;
                                break;
                        }

                    }

                    break;

                default:
                    seguirmenu = false;
                    break;
            }

        }

    }

    public static ArrayList<Jugadores> agregarJugador(ArrayList<Jugadores> nuevoJugador) {
        System.out.print("Ingrese su nombre: ");
        String nombres = leer.nextLine();
        System.out.print("Ingrese sus puntos de reputación: ");
        int puntos = leerent.nextInt();
        System.out.print("Ingrese la cantidad de dinero en su cuenta de banco: ");
        double cuenta = leerent.nextDouble();
        Jugadores jugador = new Jugadores(nombres, cuenta, puntos);
        nuevoJugador.add(jugador);
        System.out.println("¡Jugador agregado exitosamente!");

        return nuevoJugador;

    }

    public static ArrayList<Jugadores> modificarJugador(ArrayList<Jugadores> modjugador) {
        for (int i = 0; i < modjugador.size(); i++) {
            int x = i + 1;
            System.out.println("Jugador " + x + "\n" + modjugador.get(i).nombre + " | " + modjugador.get(i).puntosR + " | " + modjugador.get(i).cuantBanco + "\n");
        }
        System.out.print("Ingrese el jugador que desea modificar: ");
        int pos = leerent.nextInt();
        while (pos < 0 || pos > modjugador.size() - 1) {
            System.out.print("Opción fuera de rango \n Intentelo de nuevo: ");
            pos = leer.nextInt();
        }
        modjugador.remove(pos - 1);

        System.out.print("Ingrese su nuevo nombre: ");
        String nombrenuev = leer.nextLine();
        System.out.print("Ingrese sus puntos de reputación: ");
        int puntosnuev = leer.nextInt();
        System.out.print("Ingrese la cantidad de dinero en su cuenta de banco: ");
        double cuentanuev = leerent.nextDouble();
        Jugadores jugador = new Jugadores(nombrenuev, cuentanuev, puntosnuev);
        modjugador.add(pos - 1, jugador);
        System.out.println("¡Jugador modificado exitosamente!");

        return modjugador;

    }

    public static void listarJugadores(ArrayList<Jugadores> listJugadores) {

        for (int i = 0; i < listJugadores.size(); i++) {
            System.out.println("Jugador " + i + "\n" + listJugadores.get(i).nombre + " | " + listJugadores.get(i).puntosR + " | " + listJugadores.get(i).cuantBanco + "\n");
        }

    }

    public static ArrayList<Jugadores> eliminarJugador(ArrayList<Jugadores> elJugador) {
        for (int i = 0; i < elJugador.size(); i++) {
            int x = i + 1;
            System.out.println("Jugador " + x + "\n" + elJugador.get(i).nombre + " | " + elJugador.get(i).puntosR + " | " + elJugador.get(i).cuantBanco + "\n");
        }
        System.out.print("Ingrese el jugador que desea eliminar: ");
        int posic = leerent.nextInt();
        posic = posic - 1;
        while (posic < 0 || posic > elJugador.size() - 1) {
            System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
            posic = leer.nextInt();
            posic = posic - 1;
        }
        elJugador.remove(posic);
        System.out.println("¡Jugador eliminado exitosamente!");

        return elJugador;

    }

    public static ArrayList<Carros> agregarCarro(ArrayList<Carros> nuevoCarro) {

        System.out.print("Ingrese la marca: ");
        String marcas = leer.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelos = leer.nextLine();
        System.out.print("Ingrese el precio: ");
        double precios = leerent.nextDouble();
        boolean marcador = false;
        System.out.print("Ingrese si el carro es reconstruido [1 - SI / 2 - NO]: ");
        int resp = leerent.nextInt();

        while (resp < 0 || resp > 2) {
            System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
            resp = leerent.nextInt();
        }

        if (resp == 1) {
            marcador = true;
        }

        Color colors = JColorChooser.showDialog(null, "Ingrese un color.", Color.pink);
        Carros carro = new Carros(marcas, modelos, colors, precios, marcador);
        nuevoCarro.add(carro);
        System.out.println("¡Carro agregado exitosamente!");

        return nuevoCarro;

    }

    public static ArrayList<Carros> modificarCarro(ArrayList<Carros> modCarro, Jugadores refplayer) {

        for (int i = 0; i < modCarro.size(); i++) {
            System.out.print("Carro " + i + "\n" + modCarro.get(i).marca + " | " + modCarro.get(i).modelo + " | " + modCarro.get(i).color + " | " + modCarro.get(i).precio);
            if (modCarro.get(i).marcador == true) {
                System.out.print(" | Reconstruido");
            }else{
                System.out.print(" | Comprado");
            }
            if (modCarro.get(i).mejoras.isEmpty()) {
                System.out.print(" | Sin modificaciones.");
            } else {
                System.out.print(" | " + modCarro.get(i).mejoras.get(i));
            }
            System.out.println("");
            System.out.println("");
        }

        System.out.print("Ingrese el carro que desea modificar: ");
        int pos = leerent.nextInt();
        while (pos < 0 || pos > modCarro.size() - 1) {
            System.out.print("Opción fuera de rango \n Intentelo de nuevo: ");
            pos = leerent.nextInt();
        }
        modCarro.remove(pos);

        System.out.print("Ingrese la marca: ");
        String marcanuev = leer.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelonuev = leer.nextLine();
        System.out.print("Ingrese el precio: ");
        double precionuev = leerent.nextDouble();
        boolean marcador = false;
        System.out.print("Ingrese si el carro es reconstruido [1 - SI / 2 - NO]: ");
        int resp = leerent.nextInt();

        while (resp < 0 || resp > 2) {
            System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
            resp = leerent.nextInt();
        }

        if (resp == 1) {
            marcador = true;
        }

        Color colors = JColorChooser.showDialog(null, "Ingrese un color.", Color.pink);
        Carros carro = new Carros(marcanuev, modelonuev, colors, precionuev, marcador);

        System.out.print("Desea hacer modificaciones? [1 - SI / 2 - NO]: ");
        int respmod = leerent.nextInt();
        while (resp < 0 || resp > 2) {
            System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
            respmod = leerent.nextInt();
        }

        if (respmod == 1) {
            boolean modmenu = true;
            while (modmenu) {
                System.out.println("");
                System.out.println("----MENU MODIFICACIONES-----");
                System.out.println("1. Spoiler - Lps. 3500.00");
                System.out.println("2. Side Skirts - Lps. 1800.00");
                System.out.println("3. Front Bumper - Lps. 2000.00");
                System.out.println("4. Back Bumper - Lps. 1500.00");
                System.out.println("5. Super Builds - Lps. 8800.00");
                System.out.println("6. Salir.");
                System.out.print("Ingresar opción: ");
                int opmod = leerent.nextInt();
                System.out.println("");
                switch (opmod) {
                    case 1: //Spoiler - Lps. 3500.00
                        if (refplayer.getCuantBanco() < 3500.00) {
                            System.out.println("Su saldo no es suficiento para modificar su carro.");
                        } else {
                            carro.getMejoras().add("Spoiler");
                            carro.setPrecio(carro.getPrecio() + 3500.00);
                            refplayer.setCuantBanco(refplayer.getCuantBanco() - 3500.00);
                        }

                        break;

                    case 2:
                        if (refplayer.getCuantBanco() < 1800.00) {
                            System.out.println("Su saldo no es suficiento para modificar su carro.");
                        } else {
                            carro.getMejoras().add("Side Skirts");
                            carro.setPrecio(carro.getPrecio() + 1800.00);
                            refplayer.setCuantBanco(refplayer.getCuantBanco() - 1800.00);
                        }
                        break;

                    case 3:
                        if (refplayer.getCuantBanco() < 2000.00) {
                            System.out.println("Su saldo no es suficiento para modificar su carro.");
                        } else {
                            carro.getMejoras().add("Front Bumper");
                            carro.setPrecio(carro.getPrecio() + 2000.00);
                            refplayer.setCuantBanco(refplayer.getCuantBanco() - 2000.00);
                        }
                        
                        break;

                    case 4:
                        if (refplayer.getCuantBanco() < 1500.00) {
                            System.out.println("Su saldo no es suficiento para modificar su carro.");
                        } else {
                            carro.getMejoras().add("Back Bumper");
                            carro.setPrecio(carro.getPrecio() + 1500.00);
                            refplayer.setCuantBanco(refplayer.getCuantBanco() - 1500.00);
                        }
                        break;

                    case 5:
                        if (refplayer.getCuantBanco() < 8800.00 || marcador == false) {
                            System.out.println("Su saldo no es suficiento para modificar su carro o su carro no es reconstruido.");
                        } else {
                            carro.getMejoras().add("Super Builds");
                            carro.setPrecio(carro.getPrecio() + 8800.00);
                            refplayer.setCuantBanco(refplayer.getCuantBanco() - 8800.00);
                        }
                        break;

                    default:
                        modmenu = false;
                        break;
                }
            }
        }

        modCarro.add(pos, carro);
        System.out.println("¡Carro modificado exitosamente!");

        return modCarro;

    }

    public static void listarCarro(ArrayList<Carros> listCarro) {

        for (int i = 0; i < listCarro.size(); i++) {
            System.out.print("Carro " + i + "\n" + listCarro.get(i).marca + " | " + listCarro.get(i).modelo + " | " + listCarro.get(i).color + " | " + listCarro.get(i).precio);
            if (listCarro.get(i).marcador == true) {
                System.out.print(" | Reconstruido");
            }else{
                System.out.print(" | Comprado");
            }
            if (listCarro.get(i).mejoras.isEmpty()) {
                System.out.print(" | Sin modificaciones.");
            } else {
                System.out.print(" | " + listCarro.get(i).mejoras);
            }
            System.out.println("");
        }

    }

    public static ArrayList<Carros> eliminarCarro(ArrayList<Carros> elCarro) {

        for (int i = 0; i < elCarro.size(); i++) {
            System.out.println("Carro " + i + "\n" + elCarro.get(i).marca + " | " + elCarro.get(i).modelo + " | " + elCarro.get(i).color + elCarro.get(i).precio + elCarro.get(i).marcador);
            if (elCarro.get(i).mejoras.isEmpty()) {
                System.out.print(" | Sin modificaciones.");
            } else {
                System.out.print(" | " + elCarro.get(i).mejoras.get(i));
            }
            System.out.println("");
        }

        System.out.print("Ingrese el carro que desea eliminar: ");
        int pos = leerent.nextInt();
        while (pos < 0 || pos > elCarro.size() - 1) {
            System.out.print("Opción fuera de rango \nIntentelo de nuevo: ");
            pos = leer.nextInt();
        }
        elCarro.remove(pos);
        System.out.println("¡Carro eliminado exitosamente!");

        return elCarro;

    }

}
