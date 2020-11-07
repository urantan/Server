/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usercommandhandler;

/**
 *
 * @author ferens
 */
public class UserCommandHandler implements Runnable{
    userinterface.UserInterface myUI;
    server.Server myServer;
    String theCommand = "";

    public UserCommandHandler(userinterface.UserInterface myUI, server.Server myServer) {
        this.myUI = myUI;
        this.myServer = myServer;
    }

    public void handleUserCommand(String theCommand) {
        this.theCommand = theCommand;
        Thread myCommandThread = new Thread(this);
        myCommandThread.start();
    }
    
    public void run() {
        switch (Integer.parseInt(theCommand)) {
            case 1: //QUIT
                myServer.stopServer();
                myUI.update("Quiting program by User command.");
                System.exit(0);
                break;
            case 2: //LISTEN
                myServer.listen();
                break;
            case 3: //SET PORT
                myUI.update("The port number set function is not available at this time.");
                break;
            case 4: //GET PORT
                myUI.update("The port number is: " +String.valueOf(myServer.getPort()));
                break;
            case 5: //Stop Listening
                myServer.stopListening();
                break;
            case 6: //START SERVER SOCKET
                myServer.startServer();
                break;
            default:
                break;
        }
    }
}
