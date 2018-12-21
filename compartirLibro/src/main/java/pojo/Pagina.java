package pojo;
import java.util.ArrayList;

public class Pagina {
	
	private int numero;
	private String autor;
	private String texto;
	
	
	public Pagina(int numero) {
		this();
		this.numero = numero;
		
	}
	
	public Pagina() {
		super();
		this.numero = -1;
		this.autor = "Autor";
		this.texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget\r\n" + 
				"	interdum nisi. Vestibulum dignissim ut est ut tincidunt. Nullam commodo\r\n" + 
				"	neque est, eu porta lorem malesuada et. Sed iaculis scelerisque\r\n" + 
				"	pellentesque. Cras in dolor viverra neque tempus feugiat. Proin ac dui\r\n" + 
				"	tellus. Phasellus euismod magna ut lectus luctus feugiat. Maecenas sed\r\n" + 
				"	nunc dictum, fermentum neque a, ultricies est. Nam id elementum nunc.\r\n" + 
				"	Fusce sodales ipsum vitae quam luctus faucibus. Maecenas aliquet, erat\r\n" + 
				"	in tempus tempus, sapien arcu hendrerit dui, at venenatis leo metus\r\n" + 
				"	vitae arcu. Aenean ex leo, consectetur dapibus felis sit amet,\r\n" + 
				"	tincidunt faucibus lacus. Aliquam et varius dui. Sed hendrerit lacinia\r\n" + 
				"	ipsum. Aliquam convallis purus ut efficitur rutrum. Morbi tempus\r\n" + 
				"	porttitor ipsum, at ullamcorper nisl molestie auctor. Praesent\r\n" + 
				"	pharetra, nisi eu maximus dignissim, ante tellus tincidunt velit, quis\r\n" + 
				"	aliquam ipsum tortor at tortor. Morbi lobortis massa placerat, interdum\r\n" + 
				"	neque ut, faucibus felis. Orci varius natoque penatibus et magnis dis\r\n" + 
				"	parturient montes, nascetur ridiculus mus. Suspendisse condimentum nec\r\n" + 
				"	nulla a malesuada. Vivamus iaculis tellus eu sem molestie aliquet.\r\n" + 
				"	Pellentesque convallis neque non orci efficitur, eget egestas sapien\r\n" + 
				"	aliquam. Phasellus euismod pulvinar commodo. Nunc eu faucibus nibh. Sed\r\n" + 
				"	tempus finibus ante, ac fringilla urna maximus id. Vestibulum eget nisi\r\n" + 
				"	vitae purus laoreet pellentesque. Integer sollicitudin non nisi vitae\r\n" + 
				"	euismod. Nunc ultrices ultricies libero, dignissim tincidunt magna\r\n" + 
				"	semper a. Ut id ligula ipsum. Class aptent taciti sociosqu ad litora\r\n" + 
				"	torquent per conubia nostra, per inceptos himenaeos. Vivamus lacus\r\n" + 
				"	arcu, placerat vitae diam a, bibendum rhoncus nisl. Donec venenatis\r\n" + 
				"	auctor augue molestie cursus. Suspendisse commodo convallis posuere.\r\n" + 
				"	Mauris in pulvinar neque, eu luctus diam. Vivamus rhoncus, velit sit\r\n" + 
				"	amet consequat porttitor, libero metus dictum felis, eget dignissim\r\n" + 
				"	enim lectus vel turpis. Aenean finibus lobortis nisi non aliquam.\r\n" + 
				"	Vivamus sed tincidunt ipsum. Morbi convallis ex lectus, et ultrices\r\n" + 
				"	lectus interdum ac. Aliquam vitae diam quis nisi scelerisque sodales eu\r\n" + 
				"	at sem. Nullam quis ipsum eget augue pulvinar porta. Nullam faucibus\r\n" + 
				"	maximus turpis vulputate dignissim. Donec tincidunt nisi et sapien\r\n" + 
				"	placerat, nec auctor nisl mollis. Etiam bibendum sodales nibh, sit amet\r\n" + 
				"	facilisis dui. Vestibulum vulputate, lectus id sodales iaculis, ante\r\n" + 
				"	dolor porta arcu, at mattis leo enim a enim. Morbi maximus augue et\r\n" + 
				"	odio facilisis, vel volutpat quam tincidunt. Nullam eget enim laoreet,\r\n" + 
				"	mollis lectus sed, ultrices sapien. Sed suscipit augue eget aliquam\r\n" + 
				"	sodales. Etiam facilisis eget augue ac auctor. Pellentesque habitant\r\n" + 
				"	morbi tristique senectus et netus et malesuada fames ac turpis egestas.\r\n" + 
				"	Quisque non libero quam. Mauris rutrum mattis est, ut hendrerit sem\r\n" + 
				"	scelerisque sit amet. Nulla ut libero augue. Sed ullamcorper, quam eu\r\n" + 
				"	rutrum feugiat, quam sapien imperdiet augue, non pellentesque mauris\r\n" + 
				"	orci mollis odio. In sed feugiat dui. Morbi ornare condimentum luctus.\r\n" + 
				"	Phasellus vulputate felis vitae eros maximus gravida. Aliquam odio ex,\r\n" + 
				"	iaculis ac gravida sed, auctor scelerisque quam. Sed id blandit risus.\r\n" + 
				"	Praesent rhoncus est ligula, a euismod massa pharetra at. Maecenas\r\n" + 
				"	consequat facilisis tortor a dignissim. Suspendisse aliquet lectus\r\n" + 
				"	sodales dui hendrerit ultrices. Ut laoreet rutrum nisi, non faucibus\r\n" + 
				"	libero suscipit non. Morbi vestibulum metus interdum lacus malesuada,\r\n" + 
				"	et laoreet eros vestibulum.";
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Pagina [numero=" + numero + ", autor=" + autor + ", texto=" + texto + "]";
	}
	
	
	public Pagina getByNumero(ArrayList<Pagina> libro, int numero) {
		
		for(int i=1; i<libro.size()+1; i++) {
			Pagina pagina = libro.get(i);
			
			if(pagina.getNumero() == numero) {
				return libro.get(i);
			}
			
		}
		return null;
	}
	
	
}
