# 1000 Genomes Project dataset MCP Server

Provides natural language access to _**1000 Genomes Project dataset**_, hosted online in
_[Dnaerys variant store](https://dnaerys.org/)_
 

Dataset is sequenced & aligned to GRCh38 by _New York Genome Center_
- 2504 unrelated samples from the phase three panel
- additional 698 samples, related to samples in the 2504 panel
    - 3202 samples total (1598 males, 1604 females)
- [dataset details](https://www.internationalgenome.org/data-portal/data-collection/30x-grch38) 

### Key Features

- _real-time_ access to _138 044 724_ unique variants and about _442 billion_ individual genotypes in 3202 samples

- variant, sample, and genotype selection based on coordinates, annotations, zygosity

- filtering by VEP, ClinVar, gnomAD AF and AlphaMissense annotations
  
- filtering by inheritance model (de novo, heterozygous dominant, homozygous recessive)

## Deployments

Remote MCP service is available online via _Streamable HTTP:_

- http://db.dnaerys.org:80/mcp
- https://db.dnaerys.org:443/mcp

For local build with _stdio_ transport see [details below](#installation)

## Architecture

MCP Server is implemented as a Java EE service, providing MCP and accessing _1KGP dataset_ via
gRPC API calls to public _Dnaerys variant store_ service with _1000 Genomes dataset_ hosted online.

- service implementation is based on [Quarkus MCP Server](https://docs.quarkiverse.io/quarkus-mcp-server/dev/)
- provides MCP over _Streamable HTTP_, _HTTP/SSE_ and _STDIO_ transports


## Usage Example

Try open-ended questions to leverage analytical strength of LLMs, e.g.

> I'd like to know what disease associated mutations exist in the KGP dataset,
mostly for cancer related and blood related disorders. Find affected people
with recessive and dominant diseases and do clinical implications analysis for them.

- it might lead to analysis like [the one](https://claude.ai/public/artifacts/07bdc4ea-02db-414d-b25f-b2cdae7072d0)

## Available Tools

Tools and parameters [are here](./src/main/java/org/dnaerys/mcp/OneKGPMCPServer.java)

## Installation

Project can be run locally with MCP over _stdio_ transport, so the MCP server
can be started as a subprocess by MCP clients (like Claude Desktop or Goose).

- build the project and package it as a single _über-jar_:
    - jar is located in `target/onekgp-mcp-runner.jar` and includes all dependencies

```shell script
./mvnw clean
./mvnw package -DskipTests -Dquarkus.package.jar.type=uber-jar
```

- start from MCP client with a full path to the jar file (for _stdio_ transport,
  default configuration) or run as a separate service with streamable HTTP transport
  (requires a change in [configuration](./src/main/resources/application.properties)) 
    - project expects _JRE 21_ to be available at runtime 

```shell script
java -jar <full path>/onekgp-mcp-runner.jar
```

#### Usage with Claude Desktop

To use with Claude Desktop, add to `claude_desktop_config.json`:

```
{
  "mcpServers": {
    "OneKGP": {
      "command": "java",
      "args": ["-jar", "/full/path/onekgp-mcp-runner.jar"]
    }
  }
}
```

#### Verification

> How many variants exist in 1000 Genome Project ?


## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
