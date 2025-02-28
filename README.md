# Design e Aarquitetura de Software

## Aula 26/02/2025
Livro Eng de Software Moderna - Cap 7 https://engsoftmoderna.info/cap7.html

Uma das arquiteturas mais comuns são aquelas definidas como projetos de mais alto nível, o foco deixa de ser a organização e interfaces de classes individuais e passa a ser em unidades de maior tamanho, sejam elas pacotes, componentes, módulos, subsistemas, camadas ou serviços. Arquitetura de software não entra somente em definições de alto nível, mas também cuida da organização de pacotes, classes, db, web, devices, entidades, use cases, e outros componentes mais próximos ao código em si.
- Pacote - Agrupamento de coisas que trabalham para um sentido. Jeito de como arquivos se organizam e se movem entre si. Organização de código.
- Componentes de Software - Bibliotecas usadas para não programar coisas do 0.
- Módulos - Diferentes aplicações separadas que conversam através de u,a interface(API)
- Serviços - Uma camada que possui alguma lógica importante que faz alguma coisa.
- Interface - Comunicação entre componentes de software(API).
- Camadas - "Front, back, bd"

## Aula 27/02/2025
Padrões arquiteturais propõem uma organização de mais alto nível para sistemas de software, incluindo seus principais módulos e as relações entre eles. Essas relações definem, por exemplo, que um módulo A pode (ou não pode) usar os serviços de um módulo B. Dependendo da ocasião é possível e recomendado utilizar diferentes padrões arquiteturais juntos.
- Arquitetura em camadas - Uma das mais tradicionais, front, back e banco de dados, separar responsabilidades.
- Arquitetura Model-View-Controller ou MVC - Model:Classe  que representa informação gravada e persistida que serão utilizadas na tela; View: Desenha a tela; Controller: Separar as resposabilidades para controlar, desenhar os dados das telas. O MVC visa resolver o problema de a lógica estar na view/controlador, separando as responsabilidades. 
- Entidade: Classe  que representa informação gravada e persistida que serão utilizadas no banco.
- Microsserviços: Parte do software que faz uma tarefa muito específica, sem interface gráfica, porém com o uso de uma API Rest. Um microsserviço DEVE ter camadas, provando mais uma vez que diferentes arquiteturas podem ser utilizadas em conjunto.
- Monolito: Oposto de microsserviço. Tudo no mesmo lugar, repositório único de código; Uso de uma única tecnologia padrão; Compilado, testado e gera um único pacote; Deploy como um único sistema; Executado como um único processo no OS; Único banco de dados/repositório. 
