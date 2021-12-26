package GUI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class uiCtrl implements Initializable {

    /***
     * 普通二叉树对象
     */
    private BinaryTree.binaryTree<String> binaryTree;
    /***
     * 线索二叉树对象
     */
    private ClueBinaryTree.clueBinaryTree<String> clueBinaryTree;

    /***
     * 线索二叉树状态<br>
     * 0 未初始化
     * 1 先序
     * 2 中序
     * 3 后序
     */
    private int status = 0;

    /**
     * 算法空间复杂度切换
     */
    private boolean complex = false;

    /***
     * 创建二叉树按钮
     */
    @FXML
    private Button buildbinarytree;
    /***
     * 二叉树序列输入按钮
     */
    @FXML
    private TextField inittext;
    /***
     * 二叉树遍历结果显示
     */
    @FXML
    private ListView<String> binarytreeresult;
    /***
     * 预装载按钮1
     */
    @FXML
    private Button preload1;
    /***
     * 预装载按钮2
     */
    @FXML
    private Button preload2;
    /***
     * 预装载按钮3
     */
    @FXML
    private Button preload3;
    /***
     * 预装载按钮4
     */
    @FXML
    private Button preload4;
    /***
     * 初始化线索二叉树按钮
     */
    @FXML
    private Button initcluetreebtn;
    //二叉树遍历结果显示器
    @FXML
    private TextField clueorder;
    /***
     * 线索二叉树先序模式选择
     */
    @FXML
    private Button topre;
    /***
     * 线索二叉树中序模式选择
     */
    @FXML
    private Button toin;
    /***
     * 线索二叉树后序模式选择
     */
    @FXML
    private Button topost;
    /***
     * 线索二叉树遍历按钮
     */
    @FXML
    private Button orderit;
    /***
     * 线索二叉树高度
     */
    @FXML
    private Label height;
    /***
     * 线索二叉树大小
     */
    @FXML
    private Label size;
    /***
     * 线索二叉树叶子结点数
     */
    @FXML
    private Label leaf;
    /***
     * 显示叶子结点树前的文字
     */
    @FXML
    private Label leaftext;

    /***
     * 线索二叉树信息组合控件
     */
    @FXML
    private VBox information;

    /***
     * 后序遍历算法切换
     */
    @FXML
    private Button spacecomplex;

    /***
     * 搜索按钮
     */
    @FXML
    private Button searchbtn;
    /**
     * 搜索框
     */
    @FXML
    private TextField searchtext;
    /***
     * 搜索结果显示
     */
    @FXML
    private Label searchresult;

    /***
     * 字符串元对象集合
     */
    private ObservableList<String> dataList = FXCollections.observableArrayList();

    /***
     * 初始化函数,此函数将在界面初始化完毕后自动由FXML模块调用执行
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        dataList.add("请输入要构造的二叉树先序序列");
        dataList.add("请注意,若存在空指针请输入\"#\"占位");
        dataList.add("先序序列的末端部分不需要输入\"#\"");
        binarytreeresult.setItems(dataList);
    }

    /***
     * 绑定事件构造二叉树并遍历按钮事件
     * @param e
     */
    @FXML 
    private void binarytreebuilder(ActionEvent e) {
        binaryTree = new BinaryTree.binaryTree<String>(inittext.getText().split(","));
        dataList.clear();
        dataList.addAll("先序",binaryTree.preorder(),"中序",binaryTree.inorder(),"后序",binaryTree.postorder());
        binarytreeresult.setItems(dataList);
    }

    /***
     * 绑定事件预装载按钮1
     * @param e
     */
    @FXML
    private void preload1data(ActionEvent e) {
        inittext.setText("A,B,#,#,C");
    }
    /***
     * 绑定事件 预装载按钮2
     * @param e
     */
    @FXML
    private void preload2data(ActionEvent e) {
        inittext.setText("A,B,C,D,E,F,G");
    }
    /***
     * 绑定事件 预装载按钮3
     * @param e
     */
    @FXML
    private void preload3data(ActionEvent e) {
        inittext.setText("A,B,C,D,#,#,E,F,#,#,#,#,G,#,H,I,#,#,J,K");
    }
    /***
     * 绑定事件 预装载按钮4
     * @param e
     */
    @FXML
    private void preload4data(ActionEvent e) {
        inittext.setText("F,B,A,#,#,D,C,#,#,E,#,#,G,#,I,H");
    }

    /***
     * 绑定事件,初始化线索二叉树
     * @param e
     */
    @FXML
    private void initClueBinaryTree(ActionEvent e) {
        clueBinaryTree = new ClueBinaryTree.clueBinaryTree<String>(binaryTree);
        clueorder.setVisible(true);
        clueorder.setText("线索二叉树已初始化");
        topre.setDisable(false);
        toin.setDisable(false);
        topost.setDisable(false);
        spacecomplex.setDisable(true);
        height.setText(Integer.toString(clueBinaryTree.height()));
        size.setText(Integer.toString(clueBinaryTree.size()));
    }

    /***
     * 绑定事件 先序线索化
     */
    @FXML
    private void toClueBinaryTreePre(ActionEvent e) {
        clueBinaryTree.toClueBinaryTreePre();
        topre.setDisable(true);
        toin.setDisable(true);
        topost.setDisable(true);
        orderit.setDisable(false);
        leaftext.setVisible(true);
        leaf.setText(Integer.toString(clueBinaryTree.leaf()));
        searchbtn.setDisable(false);
        this.status = 1;
    }

    /***
     * 绑定事件 中序线索化
     */
    @FXML
    private void toClueBinaryTreeIn(ActionEvent e){
        clueBinaryTree.toClueBinaryTreeIn();
        topre.setDisable(true);
        toin.setDisable(true);
        topost.setDisable(true);
        orderit.setDisable(false);
        leaftext.setVisible(true);
        leaf.setText(Integer.toString(clueBinaryTree.leaf()));
        searchbtn.setDisable(false);
        this.status = 2;
    }

    /**
     * 绑定事件 后序线索化
     */
    @FXML
    private void toClueBinaryTreePost(ActionEvent e){
        clueBinaryTree.toClueBinaryTreePost();
        topre.setDisable(true);
        toin.setDisable(true);
        topre.setDisable(true);
        orderit.setDisable(false);
        leaftext.setVisible(true);
        leaf.setText(Integer.toString(clueBinaryTree.leaf()));
        spacecomplex.setDisable(false);
        searchbtn.setDisable(false);
        this.status = 3;
    }

    /***
     * 遍历线索二叉树
     * @param e
     */
    @FXML
    private void orderClueBinaryTree(ActionEvent e){
        switch(status){
            case 1:
                clueorder.setText(clueBinaryTree.preorder());
                break;
            case 2:
                clueorder.setText(clueBinaryTree.inorder());
                break;
            case 3:
                if(this.complex){
                    clueorder.setText(clueBinaryTree.postorder2());
                }else{
                    clueorder.setText(clueBinaryTree.postorder());
                }
                break;
        }
    }

    /**
     * 算法切换
     */
    @FXML
    private void spaceComplexChange(ActionEvent e){
        if(!this.complex){
            this.complex = true ;
            spacecomplex.setText("空间复杂");
        }else{
            this.complex = false;
            spacecomplex.setText("空间简单");
        }
    }

    @FXML
    private void search(){
        if(!searchtext.isVisible() && !searchresult.isVisible()){
            searchbtn.setText("查询元素");
            searchtext.setVisible(true);
        }else if(searchtext.isVisible()){
            searchbtn.setText("清空记录");
            searchtext.setVisible(false);
            searchresult.setVisible(true);
            searchresult.setText(Integer.toString(clueBinaryTree.level(searchtext.getText())));
            searchtext.setText("");
        }else if(searchresult.isVisible()){
            searchresult.setVisible(false);
            searchbtn.setText("查询元素所在层次");
        }
    }

}
