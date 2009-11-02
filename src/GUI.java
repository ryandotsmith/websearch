import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Container;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import org.dom4j.DocumentException;

public class GUI extends JFrame 
{
	private DefaultListModel listModel;
	private JList list;
	private ArrayList<Page> searchResults;
	private Internet internet;
	private Integer selectedRow;
	public GUI()
	{
		try{
			Page pageOne = new Page("test.html");
			Page pageTwo = new Page("dom4j.html");
			internet = new Internet();
			internet.addPage(pageOne);
			internet.addPage(pageTwo);
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
				searchResults = (ArrayList<Page>) internet.query(term);
				for( Page page : searchResults )
					listModel.addElement(page.getTitle());
			}
		}
		);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = list.getSelectedIndex();
			}
		} );

		renderPage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				Page selectedPage = searchResults.get(selectedRow-1); 
				JFrame f = new JFrame(selectedPage.getTitle());
			    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    try{
			    		JEditorPane editor = new JEditorPane( "text/html", selectedPage.getText());	
					    editor.setEditable(false);
					    JScrollPane scrollPane = new JScrollPane(editor);
					    f.add(scrollPane, BorderLayout.CENTER);
					    f.setSize(800, 600);
					    f.setVisible(true);
			    }catch(IOException e){
			    		;
			    }				
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
