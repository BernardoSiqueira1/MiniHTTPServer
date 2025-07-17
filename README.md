## Java HTTP Server

### Descrição
Este projeto é um servidor HTTP multi-thread desenvolvido em Java puro, sem dependências externas, utiliza exclusivamente os recursos nativos da JDK.

Inspirado no funcionamento do Apache Tomcat, o servidor possui algumas partes que permitem extensibilidade para o desenvolvedor. Ele permite que o desenvolvedor configure uma cadeia de filtros e handlers, os quais são executados de forma encadeada e podem aplicar lógicas específicas sobre a requisição HTTP após o parsing inicial feito pelo servidor.

Além disso, o servidor suporta a integração com serviços customizados definidos pelo desenvolvedor. Após o processamento inicial, o servidor encaminha a requisição encapsulada em um objeto para esse service customizado, que então executa a lógica de negócio da aplicação. O resultado retornado é convertido automaticamente em uma resposta HTTP válida, pronta para ser enviada ao cliente.

