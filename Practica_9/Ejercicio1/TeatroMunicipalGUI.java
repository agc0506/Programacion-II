import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Superclase abstracta
abstract class Boleto {
    protected int numero;
    protected double precio;

    public Boleto(int numero) {
        this.numero = numero;
    }

    public abstract void calcularPrecio();

    @Override
    public String toString() {
        return "Número: " + numero + ", Precio: " + precio;
    }
}

// Subclases
class Palco extends Boleto {
    public Palco(int numero) {
        super(numero);
        calcularPrecio();
    }

    public void calcularPrecio() {
        this.precio = 100.0;
    }
}

class Platea extends Boleto {
    private int diasAnticipacion;

    public Platea(int numero, int diasAnticipacion) {
        super(numero);
        this.diasAnticipacion = diasAnticipacion;
        calcularPrecio();
    }

    public void calcularPrecio() {
        this.precio = (diasAnticipacion >= 10) ? 50.0 : 60.0;
    }
}

class Galeria extends Boleto {
    private int diasAnticipacion;

    public Galeria(int numero, int diasAnticipacion) {
        super(numero);
        this.diasAnticipacion = diasAnticipacion;
        calcularPrecio();
    }

    public void calcularPrecio() {
        this.precio = (diasAnticipacion >= 10) ? 25.0 : 30.0;
    }
}

// Interfaz gráfica principal
public class TeatroMunicipalGUI extends JFrame {
    private JTextField txtNumero, txtDias;
    private JLabel lblResultado;
    private JRadioButton rbPalco, rbPlatea, rbGaleria;

    public TeatroMunicipalGUI() {
        setTitle("Teatro Municipal");
        setSize(480, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Teatro Municipal");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(140, 10, 200, 30);
        add(lblTitulo);

        // Imagen (opcional, requiere archivo local o URL)
        ImageIcon icon = new ImageIcon("teatro.jpg"); // Asegúrate de tener esta imagen o usar un path válido
        JLabel lblImg = new JLabel(icon);
        lblImg.setBounds(360, 10, 100, 60);
        add(lblImg);

        // Panel de tipo de boleto
        JPanel panelTipo = new JPanel();
        panelTipo.setBorder(BorderFactory.createTitledBorder("Datos del Boleto"));
        panelTipo.setBounds(20, 60, 430, 130);
        panelTipo.setLayout(null);

        rbPalco = new JRadioButton("Palco", true);
        rbPlatea = new JRadioButton("Platea");
        rbGaleria = new JRadioButton("Galería");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbPalco);
        grupo.add(rbPlatea);
        grupo.add(rbGaleria);

        rbPalco.setBounds(30, 20, 100, 20);
        rbPlatea.setBounds(160, 20, 100, 20);
        rbGaleria.setBounds(290, 20, 100, 20);

        panelTipo.add(rbPalco);
        panelTipo.add(rbPlatea);
        panelTipo.add(rbGaleria);

        panelTipo.add(new JLabel("Número:")).setBounds(30, 50, 100, 20);
        txtNumero = new JTextField();
        txtNumero.setBounds(130, 50, 100, 20);
        panelTipo.add(txtNumero);

        panelTipo.add(new JLabel("Cant. Días para el Evento:")).setBounds(30, 80, 160, 20);
        txtDias = new JTextField();
        txtDias.setBounds(200, 80, 100, 20);
        panelTipo.add(txtDias);

        add(panelTipo);

        // Botones
        JButton btnVender = new JButton("Vende");
        JButton btnSalir = new JButton("Salir");
        btnVender.setBounds(130, 200, 100, 30);
        btnSalir.setBounds(250, 200, 100, 30);
        add(btnVender);
        add(btnSalir);

        // Resultado
        lblResultado = new JLabel(" ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultado.setForeground(Color.BLUE);
        lblResultado.setBounds(20, 250, 440, 30);
        add(lblResultado);

        // Eventos
        btnVender.addActionListener(e -> vender());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void vender() {
        try {
            int numero = Integer.parseInt(txtNumero.getText().trim());
            int dias = txtDias.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtDias.getText().trim());
            Boleto boleto;

            if (rbPalco.isSelected()) {
                boleto = new Palco(numero);
            } else if (rbPlatea.isSelected()) {
                boleto = new Platea(numero, dias);
            } else {
                boleto = new Galeria(numero, dias);
            }

            lblResultado.setText(boleto.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TeatroMunicipalGUI().setVisible(true));
    }
}