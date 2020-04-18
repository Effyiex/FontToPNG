package cf.effyiex.converter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Converter {

    public static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789 ";

    public static void main(String[] args) throws IOException {
        Integer size = Integer.parseInt(args[1]);
        Font font = new Font(args[0], Font.PLAIN, size);
        BufferedImage output = new BufferedImage(size * CHARS.length(), size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = output.createGraphics();
        graphics.setFont(font);
        int x = 0;
        for(char ch : CHARS.toCharArray()) {
            graphics.drawString(String.valueOf(ch), x * size + (size - graphics.getFontMetrics().stringWidth(String.valueOf(ch))) / 2, size / 8 * 7);
            x++;
        }
        ImageIO.write(output, "PNG", new File(System.getProperty("user.dir") + "\\" + args[0] + ".png"));
    }

}
