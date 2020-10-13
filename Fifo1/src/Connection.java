import javax.swing.JOptionPane;

public class Connection {

	public static void main(String[] args) {
		int QntPaginas,QntFrameWork;

		QntPaginas=Integer.parseInt(JOptionPane.showInputDialog(null,"Coloque a Quantidade de Paginas"));
		QntFrameWork=Integer.parseInt(JOptionPane.showInputDialog(null,"Coloque a Quantidade de Framework"));

		Fifo fifo=new Fifo();
		fifo.setQuantidadeFrames(QntFrameWork);
		fifo.setQuantidadePaginas(QntPaginas);
		fifo.fifo();


	}

}