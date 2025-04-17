# Design e Arquitetura de Software

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

## Aula 05/03/2025
Padrão vs Estilo arquitetural: O padrão foca em solução para problemas específicos da arquitetura(Ex.: MVC); estilos arquiteturais propõem uma organização do código / projeto.
- Big ball of Mud: Ausência de padrões de arquitetura de software.
- Arquitetura de camadas: 3 camadas; Interface gráfica, lógica e banco de dados. Divisão de responsabilidade, performance, segurança, manutenibilidade.
    - Camada de apresentação: requisitos próprios
    - Camada de Lógica de negócio/aplicação: Local central para definição e atualização das regras, escalar o backend para suportar as requisições.
    - Camada de persistência/banco de dados: BD relacional - consolidada, resolve problemas de concorrência, permite compartilhamento de dados
## Aula 06/03/2025
 Who Needs an Architect? https://martinfowler.com/ieeeSoftware/whoNeedsArchitect.pdf
- O que é arquitetura? Arquitetura é um conceito social onde desenvolvedores experientes na área, ou com o sistema, discutem sobre o entendimento conjunto para todos os desenvolvedores sobre o projeto. Esse entendimento inclui como o sistema é dividido em componentes e como esses componentes se comunicam através de interfaces.
- Qual o comportamento do arquiteto da "Matrix"? O arquiteto Matrix é aquele que tenta centralizar o entendimento do sistema nele mesmo. Tenta tomar decisões importantes cedo a fim de manter uma lista de regras que os outros colegas devem seguir.
- Qual o comportamento do arquiteto ideal? O arquiteto ideal está sempre monitorando o sistema e busca corrigir erros antes deles acontecerem. O arquiteto ideal deve ser um desenvolvedor experiente que consiga colaborar com as demais pessoas envolvidas no projeto e consiga explicar o sistema e as suas consequencias para pessoas envolvidas com o código ou não. O arquiteto ideal serve mais como um guia de trilha, conhecendo os caminhos como a palma de sua mão e quando algo dá errado ele também está disponível.
## Aula 03/04/2025
Filas (qeues)
- FIFO
- Entrega pra um só.
- Remover acoplamento temporal de componentes da aplicação
- Permite acumular pedidos em caso de queda de aplicação
- Producer: Gerar mensagens(Publisher).
- Consumer: (Subscriber)
## Aula 09/04/2025
Fundamentos da Arquitetura de Software cap. 4
Backup
- Mais barato
- Demora mais para restaurar 
Réplica
- Recuperação mais rápida
- Custo maior
- Pode desincronziar
## Resumo cap. 4 do livro Fundamentos da arquitetura de software: uma abordagem de engenharia
Características da arquitetura
- Especifica uma consideração de design fora do domínio
    - Critérios operacionais e de design para o sucesso, como implementar os requisitos e por que certas escolhas foram feitas.
- Influencia algum aspecto estrutural de design
    -  Características de um sistema influenciam diretamente o design estrutural da arquitetura. A principal questão é se a característica exige um tratamento estrutural especial para garantir seu sucesso.
- É essencial ou importante para o sucesso da aplicação
    - O suporte de cada característica da arquitetura adiciona complexidade ao design. Assim, um trabalho crítico dos arquitetos é escolher menos características da arquitetura, ao invés do máximo possíve
- Características Operacionais
    - Envolvem desempenho, escalabilidade, elasticidade, disponibilidade e confiabilidade.
- Características Estruturais
    - Estrutura e qualidade do código, boa modularidade, acoplamento controlado entre os componentes, código legível.
- Características Transversais
    - Características que estão fora ou desafiam a classificação, formando restrições de design e considerações. Ex.: Legalidade
Trade-offs
- É necessário entender que qualquer decisão arquitetural deve levar em consideração o "menos pior", pois raramente terá uma característica que beneficia a aplicação como um todo e não afeta negativamente outra parte da aplicação. Ex.: Aumentar a segurança da aplicação tende a ter um impacto negativo no desempenho.
## Resumo do cap. 9 do livro Fundamentos da arquitetura de software: uma abordagem de engenharia
Padrões Fundamentais
- A Grande Bola de Lama
    - Ausência de arquitetura
    - Ocorre por falta de visão ou crescimento desenfreado
    - Dificulta qualquer alteração no código
- Arquitetura Unitária
    - Modelo mais antigo
    - Computador e um software que só roda nele como um todo
    - Comum em sitemas embarcados ou altamente restritos
- Cliente/Servidor
    - Dektop + servidor de banco de dados
        - Lógica de apresentação no desktop, enquanto as ações mais intensas computacionalmente (em volume e complexidade) ocorria nos serviços de banco de dados mais robustos.
    - Navegador + servidor de banco de dados
        - Navegador web conectado ao servidor web (que por sua vez conectava um servidor de banco de dados). A separação das responsabilidades lembrava a variante de desktop, mas com clientes ainda mais leves, como navegadores, permitindo uma distribuição mais ampla tanto dentro quanto fora dos firewalls. 
    - Três camadas
        - Interface gráfica
        - Lógica
        - Banco de dados
- Monolito
    - Uma unidade de implementação de todo o código
    - Camadas
    - Pipelines
    - Microkernel
- Distribuído
    - Várias unidades de implementação conectadas por protocolos de acesso remoto
    - Baseada em serviços
    - Orientada a eventos
    - Baseada em espaços
    - Orientada a serviços
    - Microsserviços
Falácias das arquiteturas distribuídas
- 1: A rede é confiável
    - Um serviço pode não conseguir acessar outro devido a um problema na rede
- 2: A latência é zero
    - Um protocolo de acesso remoto (REST, mensageria ou RPC) sempre será mais lento que um acesso local.
- 3: A largura da banda é infinita
    - A solicitação entre dois serviços pode chegar a níves não aceitável de banda larga utilizada se não forem tomadas as devidas precauções
- 4: A rede é segura
    - Cada endpoint para cada unidade de implementação distribuída deve ser assegurado para que solicitações desconhecidas ou ruins não cheguem nesse serviço. A área para ameaças e ataques aumenta em magnitude ao passar de uma arquitetura monolítica para uma distribuída. Ter que assegurar cada endpoint, mesmo na comunicação entre os serviços, é outro motivo para o desempenho ser mais lento nas arquiteturas síncronas e altamente distribuídas, como os microsserviços ou a arquitetura baseada em serviços.
- 5: A topologia nunca muda
    - Refere à topologia da rede em geral, inclusive todos os roteadores, hubs, switches, firewalls, redes e aparelhos usados na rede em geral.
- 6: Existe apenas um admin
    - Existem dezenas de administradores de rede em uma grande empresa típica.
    - Essa falácia aponta para a complexidade da arquitetura distribuída e a quantidade de coordenação que deve ocorrer para tudo funcionar corretamente. As aplicações monolíticas não requerem esse nível de comunicação e colaboração devido às características unitárias da implementação desses estilos de arquitetura.
- 7: O custo do transporte é zero
    - As arquiteturas distribuídas custam muito mais do que as monolíticas, basicamente devido às maiores necessidades de hardware, servidores, gateways, firewalls, novas sub-redes e proxies adicionais, entre outros.
- 8: A rede é homogênea
    - A maioria das empresas tem vários fornecedores de hardware da rede em sua infraestrutura
    - Nem todos os fornecedores de hardware heterogêneos funcionam bem juntos