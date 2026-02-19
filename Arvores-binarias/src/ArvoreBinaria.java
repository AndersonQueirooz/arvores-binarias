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

    public void remover(T conteudo) {
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }
            }

            if (atual == null) {
                throw new NullPointerException("Conteúdo não encontrado na árvore. Bloco Try");
            }

            if (pai == null) {
                if (atual.getNoDir() == null) {
                    this.raiz = atual.getNoEsq();
                } else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();
                } else {
                    for (temp = atual, filho = atual.getNoEsq(); filho.getNoDir() != null; temp = filho, filho = filho
                            .getNoEsq()) {
                        if (filho != atual.getNoEsq()) {
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            } else if (atual.getNoDir() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoEsq());
                } else {
                    pai.setNoDir(atual.getNoEsq());
                }
                
            }else if (atual.getNoEsq() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoDir());
                } else {
                    pai.setNoDir(atual.getNoDir());
                }
            } else {
                
            }

        } catch (NullPointerException erro) {
            System.out.println("Conteúdo não encontrado na árvore. Bloco Catch " + erro.getMessage());
        }
    }
    
}
