/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.main;

import blackjack.ui.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author joju
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WelcomeGUI wlc = new WelcomeGUI();
        SwingUtilities.invokeLater(wlc);
    }

}
