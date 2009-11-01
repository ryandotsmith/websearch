import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;

import org.dom4j.DocumentException;

public class GUI extends JFrame 
{
	private DefaultListModel listModel;
	private JList list;
	//Element searchTerm = new Element;
	public GUI()
	{
		try{
			Page page = new Page("test.html");
		}catch(DocumentException e){
			System.out.println("Page does not exist!");
		}
		
		listModel = new DefaultListModel();
		listModel.addElement( "" );
		list = new JList( listModel );

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );

		JButton searchTerm = new JButton( "Search Term" );
		JButton renderPage = new JButton( "Render Page" );
		
		searchTerm.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent event )
			{
				String term = JOptionPane.showInputDialog(GUI.this, "Enter search term here" );
				//listModel.addElement(page.searchTerm);				
			}
		}
		);
		
		renderPage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				JFrame f = new JFrame("Testing");
			    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    //JEditorPane editor = new JEditorPane("text/html",Internet.query(pageOne.getText()));
			    JEditorPane editor = new JEditorPane( "text/html", "<H3>Help</H3><center>www.java2s.com</center><li>One<li><i>Two</i><li><u>Three</u>");
			    editor.setEditable(false);
			    JScrollPane scrollPane = new JScrollPane(editor);
			    f.add(scrollPane, BorderLayout.CENTER);
			    f.setSize(800, 600);
			    f.setVisible(true);
				
			}
			
		});





		JPanel inputPanel = new JPanel();
		JPanel inputPanel2 = new JPanel();
		
		inputPanel.add( searchTerm );
		inputPanel2.add( renderPage );

		Container container = getContentPane();
		container.add( list, BorderLayout.CENTER );
		container.add( inputPanel, BorderLayout.NORTH );
		container.add( inputPanel2, BorderLayout.SOUTH );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setSize( 250, 300 );
		setVisible( true );

	} 
	public static void main( String args[] )
	{
		new GUI();
	}
}
