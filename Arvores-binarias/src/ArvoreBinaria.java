public class ArvoreBinaria<T extends Comparable<T>> {
    
    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo novoNo = new BinNo<>(conteudo); // Cria um novo nó com o conteúdo fornecido
        raiz = inserir(raiz, novoNo); // Chama o método recursivo para inserir o nó na árvore
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) {
            return novoNo; // Se a árvore estiver vazia, o novo nó se torna a raiz
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) { // Se o conteúdo do novo nó for menor que o conteúdo do nó atual, insere na subárvore esquerda
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else { // Caso contrário, insere na subárvore direita
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));

        }
        return atual; // Retorna o nó atual para manter a estrutura da árvore        

    }

    public void exibirInOrdem() {
        System.out.println("\n Exibindo In-Ordem:");
        exibirInOrdem(this.raiz); // Chama o método recursivo para exibir os nós em ordem
    }

    private void exibirInOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsq()); // Exibe a subárvore esquerda
            System.out.print(atual.getConteudo() + " "); // Exibe o conteúdo do nó atual
            exibirInOrdem(atual.getNoDir()); // Exibe a subárvore direita
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\n Exibindo Pré-Ordem:");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + " ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }
    
    public void exibirPosOrdem() {
        System.out.println("\n Exibindo Pós-Ordem:");
        exibirPosOrdem(this.raiz); // Chama o método recursivo para exibir os nós em pós-ordem
    }

    private void exibirPosOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq()); // Exibe a subárvore esquerda
            exibirPosOrdem(atual.getNoDir()); // Exibe a subárvore direita
            System.out.print(atual.getConteudo() + " "); // Exibe o conteúdo do nó atual
        }
    }
}
