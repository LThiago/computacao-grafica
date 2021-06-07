// TODO
package app.extra;

import app.lines.Pixel;
import app.lines.Rasterization;
import app.transformations.Image;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Representa um plano cartesiano e implementa todas as funcionalidades a qual o mesmo é responsável.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class CartesianPlane extends JPanel {

    private static CartesianPlane instance;

    /**
     * Construtor default.
     */
    private CartesianPlane() {

    }

    /**
     * Fornece instância única do Plano Cartesiano
     */
    public static synchronized CartesianPlane getInstance() {
        if (instance == null) {
            instance = new CartesianPlane();
        }
        return instance;
    }

    /**
     * Retorna a largura/comprimento do plano cartesiano.
     */
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * Retorna a altura do plano cartesiano.
     */
    public int getAltura() {
        return super.getHeight();
    }

    /**
     * Retorna o valor central X (width/2)
     */
    public int getCenterXValue() {
        return getWidth() / 2;
    }

    /**
     * Retorna o valor central Y (height/2)
     */
    public int getCenterYValue() {
        return getAltura() / 2;
    }
    
    /**
     * Retorna o valor em RGB de acordo com o valor do pixel
     */
    public int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }

    /**
     * Desenha o plano cartesiano.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        /*g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, getCenterYValue(), getWidth(), getCenterYValue()); //reta x
        g.drawLine(getCenterXValue(), 0, getCenterXValue(), getAltura()); //reta y*/
        //reta x
        Rasterization.getInstance().midpointMethod(new Pixel(-getWidth()/2,0), new Pixel(getWidth()/2,0), Color.LIGHT_GRAY, null);
        //reta y
        Rasterization.getInstance().midpointMethod(new Pixel(0, -getAltura()/2), new Pixel(0, getAltura()/2), Color.LIGHT_GRAY, null);
    }

    /**
     * Redesenha o plano cartesiano. Útil quando se quer apagar os objetos desenhados nele.
     */
    public void redraw() {
        if (instance != null) {
            instance.getGraphics().clearRect(0, 0, this.getWidth(), this.getAltura());
            this.paint(this.getGraphics()); // Desenha o plano cartesiano novamente
        }
    }

    /**
     * Desenha o eixo Z no plano cartesiano.
     */
    public void desenhaEixoZ() {
        Rasterization.getInstance().midpointMethod(new Pixel(0, 0), new Pixel(-getAltura(), -getAltura()), Color.LIGHT_GRAY, null);
        Rasterization.getInstance().midpointMethod(new Pixel(0, 0), new Pixel(getAltura(), getAltura()), Color.LIGHT_GRAY, null);
    }

    /**
     * Redesenha o espaço 3D. Útil quando se quer apagar os objetos desenhados nele.
     */
    public void redesenha3D() {
        redraw();
        desenhaEixoZ();
    }

    /**
     * Desenha o pixel no plano cartesiano de acordo com os parametros. OBS: Os pontos não são normalizados.
     */
    public void drawPixel(int x, int y, Color color) {
        Graphics g = super.getGraphics();
        g.setColor(color);
        g.fillRect(x, y, 1, 1); //acende um pixel (x,y) no plano.
    }

    /**
     * Desenha um pixel no plano cartesiano de acordo com os parametros. OBS: Os pontos são normalizados!
     */
    public void drawPixel(double x, double y, Color color) {
        //Normalizando os pontos
        x = (x + CartesianPlane.getInstance().getCenterXValue());
        y = (CartesianPlane.getInstance().getCenterYValue() - y);
        drawPixel(Math.round((float) x), Math.round((float) y), color);
    }

    /**
     * Desenha objeto 2D no plano cartesiano.
     */
    public void drawObjeto2D(double[][] matrizObjeto, Color color) {
        redraw();
        Rasterization rast = Rasterization.getInstance();
        
        rast.midpointMethod(new Pixel(matrizObjeto[0][0], matrizObjeto[1][0]), new Pixel(matrizObjeto[0][1], matrizObjeto[1][1]), color, null);
        rast.midpointMethod(new Pixel(matrizObjeto[0][1], matrizObjeto[1][1]), new Pixel(matrizObjeto[0][2], matrizObjeto[1][2]), color, null);
        rast.midpointMethod(new Pixel(matrizObjeto[0][2], matrizObjeto[1][2]), new Pixel(matrizObjeto[0][3], matrizObjeto[1][3]), color, null);
        rast.midpointMethod(new Pixel(matrizObjeto[0][3], matrizObjeto[1][3]), new Pixel(matrizObjeto[0][0], matrizObjeto[1][0]), color, null);  
    }

    /**
     * Desenha objeto 3D no espaço.
     */
    public void drawObjeto3D(double[][] matrizObjeto3D, Color color) {
        redesenha3D();
        Rasterization rast = Rasterization.getInstance();

        double fatorCentroCubo = 0; //matrizObjeto3D[0][4]/2; // (profundidade / 2)/2
        Pixel A = new Pixel(matrizObjeto3D[0][0] - fatorCentroCubo, matrizObjeto3D[1][0] - fatorCentroCubo, matrizObjeto3D[2][0] - fatorCentroCubo);
        Pixel B = new Pixel(matrizObjeto3D[0][1] - fatorCentroCubo, matrizObjeto3D[1][1] - fatorCentroCubo, matrizObjeto3D[2][1] - fatorCentroCubo);
        Pixel C = new Pixel(matrizObjeto3D[0][2] - fatorCentroCubo, matrizObjeto3D[1][2] - fatorCentroCubo, matrizObjeto3D[2][2] - fatorCentroCubo);
        Pixel D = new Pixel(matrizObjeto3D[0][3] - fatorCentroCubo, matrizObjeto3D[1][3] - fatorCentroCubo, matrizObjeto3D[2][3] - fatorCentroCubo);
        Pixel E = new Pixel(matrizObjeto3D[0][4] - fatorCentroCubo, matrizObjeto3D[1][4] - fatorCentroCubo, matrizObjeto3D[2][4] - fatorCentroCubo);
        Pixel F = new Pixel(matrizObjeto3D[0][5] - fatorCentroCubo, matrizObjeto3D[1][5] - fatorCentroCubo, matrizObjeto3D[2][5] - fatorCentroCubo);
        Pixel G = new Pixel(matrizObjeto3D[0][6] - fatorCentroCubo, matrizObjeto3D[1][6] - fatorCentroCubo, matrizObjeto3D[2][6] - fatorCentroCubo);
        Pixel H = new Pixel(matrizObjeto3D[0][7] - fatorCentroCubo, matrizObjeto3D[1][7] - fatorCentroCubo, matrizObjeto3D[2][7] - fatorCentroCubo);

        //Desenha usando o algoritmo de rasterização do Pixel Médio
        rast.midpointMethod(A, B, color, null);
        rast.midpointMethod(B, C, color, null);
        rast.midpointMethod(C, D, color, null);
        rast.midpointMethod(D, A, color, null);
        rast.midpointMethod(E, F, color, null);
        rast.midpointMethod(F, G, color, null);
        rast.midpointMethod(G, H, color, null);
        rast.midpointMethod(H, E, color, null);
        rast.midpointMethod(A, E, color, null);
        rast.midpointMethod(B, F, color, null);
        rast.midpointMethod(C, G, color, null);
        rast.midpointMethod(D, H, color, null);
    }
    
    /**
     * Desenha a ViewPort no plano cartesiano.
     * @param listaPontos vértices do ViewPort.
     */
    public void desenhaViewPort(List<Pixel> listaPontos) {
        this.redraw();
        Rasterization rast = Rasterization.getInstance();
       
        rast.midpointMethod(listaPontos.get(0), listaPontos.get(1), Color.BLACK, null);
        rast.midpointMethod(listaPontos.get(1), listaPontos.get(2), Color.BLACK, null);
        rast.midpointMethod(listaPontos.get(2), listaPontos.get(3), Color.BLACK, null);
        rast.midpointMethod(listaPontos.get(3), listaPontos.get(0), Color.BLACK, null);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Desenha imagem no plano cartesiano.
     */
    public void drawImage(Image img) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < img.getWidth(); row++) {
            for (int col = 0; col < img.getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                bufferedImg.setRGB(row, col, getCorPixel(img.getPixelMatrix()[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Desenha a imagem no plano cartesiano
     */
    public void drawImage(int[][] matrizImage, double[][] matrizPosicao) {
        redraw();
        
        BufferedImage bufferedImg = new BufferedImage(matrizImage.length, matrizImage.length, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < bufferedImg.getWidth(); row++) {
            for (int col = 0; col < bufferedImg.getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                bufferedImg.setRGB(col, row, getCorPixel((int) matrizImage[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Desenha imagem no plano cartesiano.
     */
    public void drawImage(BufferedImage bufferedImg) {
        redraw();
        this.getGraphics().drawImage(bufferedImg, getCenterXValue(), getCenterYValue() - bufferedImg.getHeight(), null);
    }

    /**
     * Recebe a imagem a ser processada e o AffineTransform contendo as
     * transformações na imagem e desenha no plano cartesiano.
     */
    public void drawImage(Image img, AffineTransform affineTransform) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < img.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < img.getBufferedImage().getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                if (row < 256 && col < 256) {
                    bufferedImg.setRGB(row, col, getCorPixel(img.getPixelMatrix()[row][col]));
                }
            }
        }
        img.setBufferedImage(bufferedImg);

        redraw(); // redraw plano cartesiano

        /**
         * Printa a imagem no plano cartesiano
         */
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setTransform(affineTransform);
        g2d.drawImage(img.getBufferedImage(), getCenterXValue(), getCenterYValue() - img.getBufferedImage().getHeight(), null);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
}