import javax.swing.JOptionPane;

public class Fifo {

	private int QntPaginas;
	private int QntFrameWork;
	int []paginas;
	int [][]matriz;
	int []falhas;
	int aux=0;

	public Fifo(){
		System.out.println("Fifo\n");
	}

	public void setQuantidadePaginas(int QntPaginas) {
		this.QntPaginas = QntPaginas;
	}

	public void setQuantidadeFrames(int QntFrameWork) {
		this.QntFrameWork = QntFrameWork;
	}

	public void iniciarxfalhas(){
		for(int i=0;i<QntPaginas;i++){
			falhas[i]=0;
		}
	}

	public void iniciarxpaginas(){
		for(int c=0;c<QntPaginas;c++){
			paginas[c]=Integer.parseInt(JOptionPane.showInputDialog(null,"Coloque a Quantidade de Paginas ["+(c+1)+"]"));
		}
	}

	public void proximo(){
		aux++;
		if(aux==QntFrameWork){
			aux=0;
		}
	}

	public boolean buscar(int PaginaAtual){
		boolean encontrado=false;
		for(int j=0;j<QntFrameWork;j++){
			if(paginas[PaginaAtual]==matriz[j][PaginaAtual]){
				encontrado=true;
			}
		}
		return encontrado;
	}


	public void modificar(boolean encontrado,int PaginaAtual){
		if(!encontrado){
			for(int aux=PaginaAtual;aux<QntPaginas;aux++){
				matriz[aux][aux]=paginas[PaginaAtual];
				falhas[PaginaAtual]=1;
			}
			proximo();
		}
	}

	public void fifo(){
		paginas= new int [QntPaginas];
		matriz= new int[QntFrameWork][QntPaginas];
		falhas= new int [QntPaginas];
		iniciarxfalhas();
		iniciarxpaginas();
		for(int i=0;i<QntPaginas;i++){
			modificar(buscar(i),i);
		}
		mostrarMatriz();
	}

	public void mostrarMatriz(){
		int QntFalhas=0;
		for(int i=0;i<QntFrameWork;i++){
			for(int j=0;j<QntPaginas;j++){
				System.out.print(""+matriz[i][j]);
			}
			System.out.println();
		}

		for(int i=0;i<QntPaginas;i++){
			if(falhas[i]==1){
				QntFalhas++;
			}
			System.out.print(""+falhas[i]);
		}
		System.out.println("\n\nFalhas Encontradas: "+QntFalhas);
	}

}