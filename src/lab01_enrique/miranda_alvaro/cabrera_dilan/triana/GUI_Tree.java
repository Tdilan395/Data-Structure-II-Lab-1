package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Esta clase contiene todos los métodos y atributos que se utilizan en la
 * realización de la interfaz gráfica.
 *
 * @author Dilan Triana
 */
public class GUI_Tree extends JFrame {

    private Nodo backRoot;
    private final JPanel panel;
    private final int width;
    private final int height;
    private final JTextArea description;
    private final JScrollPane treeBar;
    private JScrollPane descriptionBar;
    private final JButton search;
    private final JButton filter;
    private final JButton up;
    private final JButton down;
    private final JTextField searchLabel;
    private final JTextField routeLabel;
    private final JTextField matches;
    private final JList tree;
    private final JComboBox nodoType;
    private final JComboBox varType;
    private final JComboBox filterType;
    private List searchResult;
    private long now, past;
    private final Nodo n_root;
    private final DefaultComboBoxModel search_atributes[];
    private final DefaultListModel userPlaneModel;
    private final DefaultListModel commentPlaneModel;
    private final DefaultListModel postPlaneModel;

    /**
     * Método constructor parametrizado
     *
     * @param title el título de la ventanda
     * @param n_root Raíz del árbol
     * @param width Ancho de la ventana
     */
    public GUI_Tree(String title, Nodo n_root, int width) {
        
        super(title);
        this.width = width;
        this.height = width / 16 * 9;
        this.n_root = n_root;
        searchResult = new List();
        DefaultListModel model = new DefaultListModel();
        List p = n_root.getLinks();
        while(p!=null){
            model.addElement(p.getObject());
            p = p.link;
        }
        tree = new JList(model);
        treeBar = new JScrollPane();
        description = new JTextArea();
        search = new JButton("Buscar");
        filter = new JButton("Filtrar");
        up = new JButton("🔼");
        down = new JButton("🔽");
        searchLabel = new JTextField();
        up.setEnabled(false);
        down.setEnabled(false);
        matches = new JTextField();
        matches.setText("");
        routeLabel = new JTextField("Route:\\\\ Init");
        String[] basicTypeOptions = {"Users", "Post", "Comment"};
        nodoType = new JComboBox(basicTypeOptions);
        filterType = new JComboBox(basicTypeOptions);
        varType = new JComboBox();
        search_atributes = new DefaultComboBoxModel[3];
        initComboBoxAtributes();
        varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
        descriptionBar= new JScrollPane();
        panel = new JPanel();
        past = System.nanoTime();
        userPlaneModel = new DefaultListModel();
        commentPlaneModel = new DefaultListModel();
        this.postPlaneModel = new DefaultListModel();
        init();
    }

    /**
     * Método encargado de inicializar todos los componentes de la ventana, es
     * llamado por el constructor.
     * @see List
     * @see Nodo#getFather() 
     */
    private void init() {
        description.setLineWrap(true);
        description.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        description.setWrapStyleWord(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        description.setEditable(false);
        routeLabel.setEditable(false);
        matches.setEditable(false);
        setSize(width, height);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        descriptionBar.setBounds(width/2, 90, width/2-100, height/2);
        treeBar.setBounds(20, 90, width/2-100, height/2);
        up.setBounds(width/2+descriptionBar.getWidth()/2-80, 95+height/2, 50, 30);
        down.setBounds(width/2+descriptionBar.getWidth()/2+30, 95+height/2, 50, 30);
        matches.setBounds(width/2+descriptionBar.getWidth()/2-25, 95+height/2, 50, 30);
        routeLabel.setBounds(20, 40, width/2-100,25);
        nodoType.setBounds(30+width/2-100, 40, 80, 25);
        varType.setBounds(120+width/2-100, 40, 80, 25);
        searchLabel.setBounds(210+width/2-100, 40, 80, 25);
        search.setBounds(300+width/2-100, 40, 80, 25);
        filterType.setBounds(20, treeBar.getHeight()+100,120, 25);
        filter.setBounds(150,treeBar.getHeight()+100,treeBar.getWidth()-130, 25);
        
        setDesignColor();
        
        
        matches.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        panel.add(descriptionBar);
        panel.add(treeBar);
        panel.add(up);
        panel.add(down);
        panel.add(matches);
        panel.add(routeLabel);
        panel.add(searchLabel);
        panel.add(nodoType);
        panel.add(varType);
        panel.add(filterType);
        panel.add(search);
        panel.add(filter);
        descriptionBar.setViewportView(description);
        treeBar.setViewportView(tree);

        showCommentsModel(commentPlaneModel);
        showPlaneModel(n_root, 0, postPlaneModel);
        showUsersModel(userPlaneModel);
        this.setResizable(false);
        this.setVisible(true);

        nodoType.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
            }
        });

        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultListModel model = (DefaultListModel) tree.getModel();
                setEtiquetasFalse();

                switch ((String) filterType.getSelectedItem()) {
                    case "Users":
                        routeLabel.setText("Route:\\\\ Init");
                        tree.setModel(userPlaneModel);
//                            showUsersModel(model);
                        break;
                    case "Post":
                        routeLabel.setText("Route:\\\\ Init_Posts");
                        tree.setModel(postPlaneModel);
//                            showPlaneModel(n_root,0,model);
                        break;
                    case "Comment":
                        routeLabel.setText("Route:\\\\ Init_Comments");
                        tree.setModel(commentPlaneModel);
//                          showCommentsModel(model);
                        break;
                }

            }

        });

        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!searchLabel.getText().isEmpty()) {
                    description.setText("");
                    switch ((String) nodoType.getSelectedItem()) {
                        case "Users":
                            searchResult = n_root.search((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                        case "Post":
                            searchResult = n_root.searchPost((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                        case "Comment":
                            searchResult = n_root.searchComment((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                    }

                    if (!searchResult.isEmpty()) {
                        description.append(((Nodo) searchResult.getObjectByIndex(0)).printInfo());
                        showList(((Nodo) searchResult.getObjectByIndex(0)).getFather());
                        matches.setText("1");
                    } else {
                        description.append("No se encontró " + (String) nodoType.getSelectedItem() + " buscado por " + varType.getSelectedItem() + ": " + searchLabel.getText() + "\n");
                    }
                    searchLabel.setText("");
                    setPages();
                }
            }

        });

        up.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minus();
                String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
                int i = Integer.parseInt(iValue) - 1;
                description.setText("");
                if(searchResult.getObjectByIndex(i)==null)i++;
                description.append(((Nodo) searchResult.getObjectByIndex(i)).printInfo());
                showList(((Nodo) searchResult.getObjectByIndex(i)).getFather());
                }
        });

        down.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plus();
                String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
                int i = Integer.parseInt(iValue) - 1;
                description.setText("");
                if(searchResult.getObjectByIndex(i)==null)i++;
                description.append(((Nodo)searchResult.getObjectByIndex(i)).printInfo());
                showList(((Nodo) searchResult.getObjectByIndex(i)).getFather());
            }
        });

        tree.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            
            Nodo n = (Nodo)tree.getSelectedValue();
            if(n==null)return;
            
            description.setText(n.printInfo());
            searchResult = new List();
            up.setEnabled(false);
            down.setEnabled(false);
            matches.setText("");
        }
        });

        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                now = System.nanoTime();

                //System.out.println("Run Test00 "+(now-past));
                if (now - past <= 250000000) {
                    Nodo nodo = (Nodo) tree.getSelectedValue();

                    if (tree.getSelectedIndex() == 0) {
                        nodo.etiquetaSelection = false;
                    }

                    showList(nodo);
                }
                past = now;
            }
        });
    }

    /**
     * Método para cambiar la etiqueta del nodo inicial de la lista que sirve
     * para regresarse
     */
    private void setEtiquetasFalse() {
        if (backRoot != null) {
            backRoot.etiquetaSelection = false;
        }
    }

    /**
     * Método para indicar la ruta en la que se encuentra el usuario
     *
     * @param nodo nodo que fue seleccionado
     */
    public void setRoute(Nodo nodo) {
        Nodo p = nodo;
        String route = "";

        while (p.getFather() != null) {
            route = (" → " + p.getSingleRoute() + route);
            p = p.getFather();
        }
        routeLabel.setText("Route:\\\\ Init" + route);
    }

    /**
     * Método para mostrar la lista basada en la selección o la busqueda
     *
     * @param nodo nodo seleccionado o encontrado
     */
    private void showList(Nodo nodo) {

        DefaultListModel modelo = (tree.getModel() == userPlaneModel || tree.getModel() == commentPlaneModel || tree.getModel() == postPlaneModel) ? new DefaultListModel() : (DefaultListModel) tree.getModel();
        if (modelo.isEmpty()) {
            tree.setModel(modelo);
        }
        modelo.clear();
        setRoute(nodo);
        if (nodo.getFather() != null) {
            setEtiquetasFalse();
            nodo.getFather().etiquetaSelection = true;
            backRoot = nodo.getFather();
        }
        modelo.addElement(nodo.getFather());
        List p = nodo.getLinks();
        while(p!=null) {
            modelo.addElement(p.getObject());
            p = p.link;
        }
    }

    /**
     * Método para navegar entre los distintos resultados obtenidos en la
     * busqueda, en caso de ocurrir.
     */
    public void plus() {
        String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
        int i = Integer.parseInt(iValue);
        if (i >= searchResult.size() - 1) {
            down.setEnabled(false);
        }
        if (i == 1) {
            up.setEnabled(true);
        }
        matches.setText(String.valueOf(i + 1) + "/" + searchResult.size());
    }

    /**
     * Método para navegar entre los distintos resultados obtenidos en la
     * busqueda, en caso de ocurrir.
     */
    public void minus() {
        String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
        int i = Integer.parseInt(iValue);
        if (i == 2) {
            up.setEnabled(false);
        }
        if (i == searchResult.size()) {
            down.setEnabled(true);
        }
        matches.setText(String.valueOf(i - 1) + "/" + searchResult.size());
    }

    /**
     * Método para seleccionar el número de coincidencias encontradas.
     */
    private void setPages() {
        if (searchResult == null || searchResult.isEmpty()) {
            matches.setText("0");
            
            down.setEnabled(false);
            up.setEnabled(false);
        } else if (searchResult.size() == 1) {
            matches.setText("1");
            down.setEnabled(false);
            up.setEnabled(false);
        } else if (searchResult.size() > 1) {
            matches.setText("1/" + searchResult.size());
            down.setEnabled(true);
            up.setEnabled(false);
        }
    }

    /**
     * Método para inicializar los atributos del combo box.
     */
    private void initComboBoxAtributes() {
        this.search_atributes[0] = new DefaultComboBoxModel();
        this.search_atributes[0].addElement("id");
        this.search_atributes[0].addElement("name");
        this.search_atributes[0].addElement("username");
        this.search_atributes[0].addElement("email");
        this.search_atributes[0].addElement("city");
        this.search_atributes[0].addElement("phone");
        this.search_atributes[0].addElement("website");
        this.search_atributes[0].addElement("comp-name");
        this.search_atributes[1] = new DefaultComboBoxModel();
        this.search_atributes[1].addElement("userId");
        this.search_atributes[1].addElement("id");
        this.search_atributes[1].addElement("title");
        this.search_atributes[1].addElement("body");
        this.search_atributes[2] = new DefaultComboBoxModel();
        this.search_atributes[2].addElement("postId");
        this.search_atributes[2].addElement("id");
        this.search_atributes[2].addElement("name");
        this.search_atributes[2].addElement("email");
        this.search_atributes[2].addElement("body");
    }

    /**
     * Método para encontrar el indice de un caracter especifico en una cadena
     * de caracteres
     *
     * @param text string a evaluar
     * @param key el caracter a buscar
     * @return retornar la posición del caracter que se está buscando.
     */
    private int indexOf(String text, String key) {
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).equals(key)) {
                return i;
            }
        }
        return 1;
    }

    /**
     *Método para construir la lista de usuarios en el modelo JList
     *
     * @param model el modelo del JList.
     * @see List#getObject() 
     */
    private void showUsersModel(DefaultListModel model) {
        List p = n_root.getLinks();
        while (p != null) {
            model.addElement(p.getObject());
            p = p.link;
        }
    }

    /**
     * Método para añadir en un plano todos los nodos de cierto tipo de nodo
     *
     * @param core nodo raíz
     * @param i el nodo por el que está pasando
     * @param model el modelo del Jlist
     */
    private void showPlaneModel(Nodo core, int i, DefaultListModel model) {
        if (i == core.getLinks().size()) {
            return;
        }

        List p = core.getLink(i).getLinks();
        while (p != null) {
            model.addElement(p.getObject());
            p = p.link;
        }

        showPlaneModel(core, i + 1, model);
    }
    /**
     * Método para construir la lista de comentarios en el modelo JList
     * @param model el modelo de Jlist
     * @see #showPlaneModel()
     */
    private void showCommentsModel(DefaultListModel model) {
        List p = n_root.getLinks();
        int i=0;
        while (p != null) {
            showPlaneModel((Nodo) p.getObject(), 0, model);
            p = p.link;
            i++;
        }
    }

    private void setDesignColor() {
        //ComboBoxes
        filterType.setBackground(new Color(0xff1e5f74));//407088
        filterType.setForeground(Color.WHITE);
        filterType.setFocusable(false);
        varType.setBackground(new Color(0xff1e5f74));
        varType.setForeground(Color.WHITE);
        varType.setFocusable(false);
        nodoType.setBackground(new Color(0xff1e5f74));
        nodoType.setForeground(Color.WHITE); 
        nodoType.setFocusable(false);
        
        //Labels
        searchLabel.setBackground(new Color(0xfff0ece3));
        routeLabel.setBackground(new Color(0xfff0ece3));
        matches.setBackground(new Color(0xfff0ece3));
        
        
        //buttons
        search.setBackground(new Color(0xff1d2d50));
        search.setForeground(Color.WHITE);
        search.setFocusPainted(false);
        up.setBackground(new Color(0xff1d2d50));//132743
        up.setForeground(Color.WHITE);
        up.setFocusPainted(false);
        down.setBackground(new Color(0xff1d2d50));
        down.setForeground(Color.WHITE);
        down.setFocusPainted(false);
        filter.setBackground(new Color(0xff1d2d50));
        filter.setForeground(Color.WHITE);
        filter.setFocusable(false);
       
        //info
        description.setBackground(new Color(0xfff0ece3));
        tree.setBackground(new Color(0xfff0ece3));
        
        panel.setBackground(new Color(0xff596e79));
    }

}
