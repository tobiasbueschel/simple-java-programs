package tutorial_5.xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;

public class Xml extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private String text = null;
  private final static Logger LOGGER = Logger.getLogger(Xml.class.getName());
  private File xml;
  private StringBuffer content;
  private Boolean verified = false;


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Xml frame = new Xml();
          frame.setVisible(true);

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Xml() {

    setTitle("XML Processing");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 766, 250);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    // creates first textArea and ScrollPane
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBounds(6, 50, 361, 162);

    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    contentPane.add(scroll);

    // 2nd textArea & ScrollPane
    JTextArea textArea2 = new JTextArea();
    JScrollPane scroll2 = new JScrollPane(textArea2,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll2.setBounds(400, 50, 361, 162);

    textArea2.setLineWrap(true);
    textArea2.setWrapStyleWord(true);
    contentPane.add(scroll2);

    // r
    JButton btnChooseFile = new JButton("Choose file");
    btnChooseFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(System
          .getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
          xml = fileChooser.getSelectedFile();
          System.out.println("Selected file: "
            + xml.getAbsolutePath());
        }

        try {
          content = new StringBuffer();
          BufferedReader in = new BufferedReader(new FileReader(xml));

          // source:
          // http://www.java2s.com/Code/Java/File-Input-Output/Readatextfile.htm
          while ((text = in.readLine()) != null) {
            content.append(text)
              .append(
                System.getProperty("line.separator"));
          }
          textArea.setText(content.toString());
          in.close();

        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        } catch (IOException e1) {
          e1.printStackTrace();
        }

      }
    });

    btnChooseFile.setBounds(6, 9, 117, 29);
    contentPane.add(btnChooseFile);

    JButton btnVerify = new JButton("Verify");
    btnVerify.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          textArea2.setText("");
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	            factory.setValidating(false);
//	            factory.setNamespaceAware(true);
//	            builder.setErrorHandler(new SimpleErrorHandler());

          DocumentBuilder builder = factory.newDocumentBuilder();
          builder.parse(new InputSource(new StringReader(textArea.getText())));
          verified = true;
          textArea2.setForeground(Color.GREEN);
          textArea2.setText("Verified");

        } catch (SAXException | IOException | ParserConfigurationException e2) {
          LOGGER.warning(e2.getMessage());
          verified = false;
          textArea2.setForeground(Color.RED);
          textArea2.setText(e2.getMessage());
        }
      }
    });
    btnVerify.setBounds(124, 9, 117, 29);
    contentPane.add(btnVerify);

    JButton btnSave = new JButton("Save");
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {

        if (verified) {
          FileWriter fw;
          try {
            fw = new FileWriter(xml.getAbsoluteFile(), true);
            textArea.write(fw);
            textArea2.setForeground(Color.GREEN);
            textArea2.setText("XML file has been saved!");
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        } else {
          textArea2.setForeground(Color.ORANGE);
          textArea2.setText("Please verify the XML code before saving!");
        }

      }
    });
    btnSave.setBounds(240, 9, 117, 29);
    contentPane.add(btnSave);

  }
}
