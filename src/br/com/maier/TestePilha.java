package br.com.maier;
import javax.swing.*;
public class TestePilha {

	private static class Pilha{
		public int numero;
		public double valor;
		public int pedido;
		public Pilha prox;
	}
	public static void main (String[] args) {
		Pilha topo = null;
		Pilha aux;
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));
			if (op <1|| op > 6) {
				mensagem("Opção inválida");
			}
			if (op==1) {
				int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO DA CHAPA","0"));
				aux = topo;
				boolean achou = false;
				while(aux != null) {
					if (aux.numero == numero) {
						achou = true;
						mensagem("ESSE NUMERO DE CHAPA JÁ FOI CADASTRADO.\nFAVOR VERIFICAR!");
						break;
					}
					aux = aux.prox;
				}
			if(achou==false) {
				Pilha novo = new Pilha();
				novo.numero = numero;
				novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA","0"));
				novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("NUMERO DA PEDIDO","0"));
				novo.prox = topo;
				topo = novo;
			}
		}
			if (op == 2) {
				if (topo == null) {
					mensagem("A PILHA ESTÁ VAZIA!");
				}else {
					JTextArea saida = new JTextArea(6,35);
					JScrollPane scroll = new JScrollPane(saida);
					saida.append("NUMERO \t" + "VALOR\t" + "PEDIDO\n");
					saida.append("================================\n");
					aux = topo;
					while (aux!=null) {
						if(aux.prox != null) {
							System.out.println("Num: " + aux.numero + ", endereço: "+aux.hashCode() + " Prox => "+aux.prox.hashCode()+"\n");
						}
						saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
						aux=aux.prox;
					}
					JOptionPane.showMessageDialog(null, scroll,"CONSULTAR CHAPAS CADASTRADAS",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(op == 3) {
			if(topo==null) {
				mensagem("A PILHA ESTA VAZIA");
			} else {
				mensagem("NUMERO: "+topo.numero +", FOI REMOVIDO.");
				topo = topo.prox;
			}
		}
		if (op == 4) {
			if(topo == null) {
				mensagem("A PILHA ESTA VAZIA");
			}else {
				topo = null;
				mensagem("A PILHA FOI ESVAZIADA");
			}
		}	
		if(op == 5) {
			aux = topo;
			int n = 0;
			while(aux != null) {
				aux = aux.prox;
				n++;
			}
			mensagem("A PILHA CONTEM:" +n+" ELEMENTOS.");
		}
		if(op==6) {
			if (topo == null) {
				mensagem("A PILHA ESTA VAZIA");
			}else {
				int npedido = Integer.parseInt(JOptionPane.showInputDialog("NUMERO DO PEDIDO", "0"));
				JTextArea saida = new JTextArea(6,35);
				JScrollPane scroll = new JScrollPane(saida);
				saida.append("FILTRO, CHAPAS PARA O PEDIDO NRO: "+npedido+"\n");
				saida.append("NUMERO\t"+"VALOR\t"+"PEDIDO\n");
				saida.append("=============================");
				aux = topo;
				while(aux != null) {
					if (aux.pedido == npedido) {
						saida.append(aux.numero + "\t" + aux.valor + "\t" + "\n");
					}
					aux = aux.prox;
				}
				JOptionPane.showMessageDialog(null,scroll, "CONSULTAR CHAPAS CADASTRADAS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}while (op != 6);
}
	private static String opcoesMenu() {
		String menu = "\nMENU DE OPÇÕES\n"+"\n1 - EMPILHAR CHAPAS."
					+"\n2 - CONSULTAR TODAS AS CHAPAS."
					+"\n3 - DESEMPILHAR CHAPAS."
					+"\n4 - REMOVER TODAS AS CHAPAS DA PILHA"
					+"\n5 - VERIFICAR QUANTIDADE DE CHAPAS."
					+"\n6 - SAIR";
		return menu;
	}
	private static void mensagem(String a) {
		JOptionPane.showMessageDialog(null, a,"MENSAGEM DO PROGRAMA", JOptionPane.INFORMATION_MESSAGE);
	}
}
