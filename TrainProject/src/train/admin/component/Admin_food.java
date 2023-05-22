package train.admin.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.dao.FoodDAO;
import train.dto.FoodDTO;

public class Admin_food extends JPanel {
	
	FoodDAO fooddao = new FoodDAO();
	List<FoodDTO> allFoodList = fooddao.getFoodAll();
	
	String[] orderTableColumnName = {"음식No.", "대분류", "이름", "가격", "삭제"};
	String[] categoryMenuName = {"식사류", "면류", "간식류", "음료"};
	
	JPanel mainPanel, addMenuPanel;
	JButton searchBtn, addImageBtn, addMenuBtn;
	JTextField foodnametext, pricetext, imageFileNameLab;
	JTable order_table;
	JScrollPane user_sp;
	DefaultTableModel order_dtm;
	
	public Admin_food() {
		// 기본 양식
		setBounds(441, 80, 1350, 800);		
		setBackground(Color.white);
		setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 100, 1350, 480);
		add(mainPanel);
		mainPanel.setLayout(new GridLayout());
		
		order_dtm = new DefaultTableModel(orderTableColumnName, 0);		
		order_table = new JTable(order_dtm);
			// 테이블 양식
			order_table.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));	
			order_table.getTableHeader().setFont(new Font("HY헤드라인M", Font.BOLD, 20));
			order_table.setRowHeight(50);
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			order_table.getColumn("음식No.").setCellRenderer(celAlignCenter);
			order_table.getColumn("대분류").setCellRenderer(celAlignCenter);
			order_table.getColumn("이름").setCellRenderer(celAlignCenter);
			order_table.getColumn("가격").setCellRenderer(celAlignCenter);
			order_table.getColumn("삭제").setCellRenderer(celAlignCenter);
			order_table.getColumn("음식No.").setPreferredWidth(100);		
			order_table.getColumn("대분류").setPreferredWidth(100);	
			order_table.getColumn("이름").setPreferredWidth(150);
			order_table.getColumn("가격").setPreferredWidth(50);
			order_table.getColumn("삭제").setPreferredWidth(10);
			
			order_table.getColumn("삭제").setCellRenderer(new AdminBtn("삭제", order_table));
			order_table.getColumn("삭제").setCellEditor(new AdminBtn("삭제", order_table));
		
		user_sp = new JScrollPane(order_table);
		user_sp.setBounds(60, 50, 1350, 800);
		mainPanel.add(user_sp);
		
		searchBtn = new JButton("조회");
		searchBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				getMenuValue(order_dtm);			
			}
		});
		searchBtn.setBackground(new Color(0, 128, 192));
		searchBtn.setForeground(Color.white);
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		searchBtn.setBounds(10, 20, 220, 60);
		add(searchBtn);
		
		addMenuPanel = new JPanel();
		addMenuPanel.setBackground(new Color(255, 255, 255));
		addMenuPanel.setBounds(0, 605, 1200, 156);
		add(addMenuPanel);
		addMenuPanel.setLayout(null);
		
		JLabel categoryLabel = new JLabel("대분류");
		categoryLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		categoryLabel.setBounds(12, 45, 72, 40);
		addMenuPanel.add(categoryLabel);
		
		JLabel foodNameLab = new JLabel("음식명");
		foodNameLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		foodNameLab.setBounds(337, 45, 72, 40);
		addMenuPanel.add(foodNameLab);
		
		JLabel priceLab = new JLabel("가격");
		priceLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		priceLab.setBounds(711, 42, 45, 40);
		addMenuPanel.add(priceLab);
		
		JComboBox<String> categorycomboBox = new JComboBox<>(categoryMenuName);
		categorycomboBox.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		categorycomboBox.setBounds(83, 45, 225, 40);
		addMenuPanel.add(categorycomboBox);
		
		foodnametext = new JTextField();
		foodnametext.setColumns(10);
		foodnametext.setBounds(421, 48, 248, 40);
		addMenuPanel.add(foodnametext);
		
		pricetext = new JTextField();
		pricetext.setColumns(10);
		pricetext.setBounds(768, 45, 187, 40);
		addMenuPanel.add(pricetext);
		
		JLabel NotionLab = new JLabel("※ 메뉴 추가 시, 음식 No는 자동으로 부여됩니다");
		NotionLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		NotionLab.setForeground(new Color(0, 128, 255));
		NotionLab.setBounds(12, 10, 332, 25);
		addMenuPanel.add(NotionLab);
		
		imageFileNameLab = new JTextField();
		imageFileNameLab.setColumns(10);
		imageFileNameLab.setBounds(589, 106, 248, 40);
		addMenuPanel.add(imageFileNameLab);
		
		addImageBtn = new JButton("이미지 추가");
		addImageBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 13));
		addImageBtn.setBounds(849, 105, 106, 40);
		addImageBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				uploadImage();
			}
		});
		addMenuPanel.add(addImageBtn);
		
		addMenuBtn = new JButton("메뉴 추가");
		addMenuBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		addMenuBtn.setBounds(1028, 49, 127, 77);
		// 메뉴 추가 눌렀을 때, 유효성 검사 -> 안맞는거 다이얼로그 오픈
		addMenuBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodName = foodnametext.getText();
				String price = pricetext.getText();
				String image = imageFileNameLab.getText();
				
				if (foodName.isBlank()) {
					JOptionPane.showMessageDialog(null, "음식명을 입력해주세요"
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				if (price.isBlank()) {
					JOptionPane.showMessageDialog(null, "가격을 입력해주세요"
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				for (int i = 0; i < price.length(); ++i) {
					if (!(price.charAt(i) >= '0' && price.charAt(i) <= '9')) {
						JOptionPane.showMessageDialog(null, "가격은 숫자만 입력해주세요"
								,"Warning", JOptionPane.DEFAULT_OPTION);
						pricetext.setText(null);
						return;
					}
				}
				
				if (image.isBlank()) {
					JOptionPane.showMessageDialog(null, "메뉴의 이미지 파일을 추가해주세요."
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				fooddao.addFood(categorycomboBox.getSelectedItem().toString(), foodName, Integer.valueOf(price), image);
				foodnametext.setText(null);
				pricetext.setText(null);
				imageFileNameLab.setText(null);
				getMenuValue(order_dtm);
			}
		});
		addMenuPanel.add(addMenuBtn);
	}
	
	/** 이미지를 업로드하는 메소드 */
	void uploadImage() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("이미지 파일 불러오기");
		chooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() { // jpg png만 보이게
            
            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return null;
            }
           
            @Override
            public boolean accept(File f) {
                // TODO Auto-generated method stub
                String fileName = f.getName();

                if(fileName.indexOf(".png") != -1)
                {
                    return true;
                }
                else if(fileName.indexOf(".jpg") != -1)
                {
                    return true;
                }
                else if(f.isDirectory())
                {
                    return true;
                }
               
                return false;
            }
        });
		   
	  	int returnVal = chooser.showSaveDialog(null);	  	
	  	if (returnVal == chooser.APPROVE_OPTION) {
	  		File selectedFile = chooser.getSelectedFile();
	  		String destinationFolder = "resource/";
	  		
	  		if (selectedFile == null) {
	  			return;
	  		}
	  		
	  		try {
                Path sourcePath = selectedFile.toPath();
                Path destinationPath = new File(destinationFolder, selectedFile.getName()).toPath();
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "파일 저장 완료", "성공", JOptionPane.INFORMATION_MESSAGE);
                imageFileNameLab.setText(chooser.getSelectedFile().getName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "파일 저장 중 오류 발생", "오류", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
	  	}
	  	
	}	
	
	/** DB에서 차내식을 조회하여 테이블에 출력하는 메소드 */
	void getMenuValue(DefaultTableModel order_dtm) {
		order_dtm.setNumRows(0); // 테이블 초기화
		
		allFoodList = fooddao.getFoodAll();
		
		for (FoodDTO food : allFoodList) {
			Vector<Object> list = new Vector<>();
			list.add(food.getFood_number());
			list.add(food.getfood_type());
			list.add(food.getFood_name());
			list.add(food.getFood_price());
			list.add(food.getImage_location());
			order_dtm.addRow(list);
		}
	}
}
