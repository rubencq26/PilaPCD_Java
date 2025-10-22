/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author rubco
 */
public class CanvasPila extends Canvas {

    private List<Object> elementos;
    private Image fondo;
    private Color colorPilaVacia = Color.BLACK;
    private Color colorPilaLlena = Color.BLACK;

    public CanvasPila(int ancho, int alto) {
        setSize(ancho, alto);
        fondo = new ImageIcon(getClass().getResource("/InterfazGrafica/fondo.jpg")).getImage();
        elementos = new ArrayList<>();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        og.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

        og.setColor(Color.BLACK);
        og.setFont(new Font("Berlin Sans FB", Font.BOLD, 36));
        og.drawString("PilaLenta", 200, 100);

        og.setFont(new Font("Arial", Font.BOLD, 15));
        og.setColor(colorPilaVacia);
        og.drawString("PILA VACIA", 60, 500);
        og.setColor(colorPilaLlena);
        og.drawString("PILA LLENA", 450, 500);

        og.setColor(Color.LIGHT_GRAY);
        int anchoRect = 200;
        int altoRect = 40;
        int pixelX = 200;
        int pixelY = getHeight() - 50;
        for (int i = 0; i < 8; i++) {
            int y = pixelY - i * (altoRect + 10);
            og.fillRect(pixelX, y - altoRect, anchoRect, altoRect);
            og.setColor(Color.BLACK);
            og.drawRect(pixelX, y - altoRect, anchoRect, altoRect); // borde negro
            og.setColor(Color.LIGHT_GRAY);
        }

        og.setFont(new Font("Arial", Font.BOLD, 16));
        og.setColor(Color.BLACK);

        int n = elementos.size();
        for (int i = 0; i < n; i++) {
            Object obj = elementos.get(i);
            if (obj != null) {
                String valor = obj.toString();
                int indice = n - 1 - i;

                int posY = pixelY - indice * (altoRect + 10);
                og.setColor(Color.DARK_GRAY);
                og.fillRect(pixelX, posY - altoRect, anchoRect, altoRect);
                og.setColor(Color.BLACK);
                og.drawRect(pixelX, posY - altoRect, anchoRect, altoRect);

                // Dibujar el texto
                og.setColor(Color.WHITE); // Texto en blanco para contraste
                int textoAncho = og.getFontMetrics().stringWidth(valor);
                int textoX = pixelX + (anchoRect - textoAncho) / 2;
                int textoY = posY - (altoRect / 2) + 5;
                og.drawString(valor, textoX, textoY);
            }
        }

        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void representa(List<Object> nuevaPila) {
        this.elementos = new ArrayList<>(nuevaPila);
        repaint();
    }

    public void setColorPilaVacia(Color c) {
        colorPilaVacia = c;
    }

    public void setColorPilaLlena(Color c) {
        colorPilaLlena = c;
    }
}
