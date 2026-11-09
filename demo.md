# IntelliJ IDEA tippek-trükkök

## IntelliJ IDEA: The Documentary | An origin story

[IntelliJ IDEA: The Documentary | An origin story](https://www.youtube.com/watch?v=Kourq_Lz03U)

## What's new

* [What's New in IntelliJ IDEA...](https://www.jetbrains.com/idea/whatsnew/)
*  A 2025.3-as verziótól kezdve a korábban különálló Community és Ultimate kiadások egyetlen, egységes IntelliJ IDEA disztribúcióvá olvadtak össze
* Főverziók (Major Releases): Évente 3 alkalommal jelennek meg (például 2026.1, 2026.2, 2026.3 formátumban, kb. 3–4 havonta)

## Tip: Gyors műveletek

- Ctrl Shift A - Menu / Shortcut

## Tip: Navigálás

- Alt 1 - Project ablak, itt Alt Insert create
- Itt Space - Preview files
- Ctrl + B - go to declaration
- Alt Up, Alt Down - Ugrálás a metódusok között

## Tip: Keresés

- Shift Shift - Search Everywhere
- Search Structurally

```
@OneToMany(fetch = FetchType.EAGER)
$Type$ $field$;
```

## Tip: Scope

- Fájlok egy csoportja
- `src:**.*Controller`
- Más színnel jeleníthető meg

## Tip: Custom inspections

- Structural search

## Tip: Kódszerkesztés

- Select
    - Ctrl + W - extend selection
    - Kijelölés középső egérgombbal: rectangular select
- Alt Shift Click - multiple carret
- Ctrl Shift Backspace ugrás a legutóbbi szerkesztés helyére
- Shift Enter - Add line before
- Ctrl Alt Enter - Add line after
- `.`, `..` Command completion
- Ctrl Shift V - Copy - Paste history
- Alt Insert / Delegate (Controllerben)

## Tip: Compare

- Két fájl kiválasztása, majd Ctrl D
    - Könyvtárra is működik
- Jobb klikk / Compare with Clipboard
- Ctrl Shift / Open Blank Diff Window

## Tip: Maven

- `pom.xml` Alt Insert / Dependency
- Automatikus kiegészítés esetén jelöli, hogy mi van lokálisan és mi felhőben

## Tip: Debug

- Collection viewer
    - Debugban a List-en Explore elements
- Renderer, `@Renderer`

```xml
<dependency>
    <groupId>org.jetbrains</groupId>
    <artifactId>annotations</artifactId>
    <version>26.1.0</version>
</dependency>
```

`EmployeeDto`:

```java
@Debug.Renderer(text = """
        String.format("(%d) %s", id, name)
        """)
```

- Java Stream Debugger
    - (Demó: enroll)
- Logpoints, Non-suspending breakpoints
    - Shift + Click
    - Csak naplóz
    - Ciklusban kérdezett le, és futás közben tette fel a logpointot
    - 3rd party libben is el lehet helyezni, míg a loggert nem
    - Open logpoint definition
- Label, Object marker
- Modify
    - Return to a previous stack frame
    - Force return from the current method
    - Throw an exception
    - HotSwap

## Tip: Spring

- Spring Beans Dependencies diagram
- Beanek közötti ugrás    
- Spring Debugger Plugin
    - Beans
    - Properties
    - Active DB Connection Display
    - Transaction Status Display, entity
    - L2 cache
    - Entity State in Watches
- Language injection: SpEL

## Tip: Spring DevTools

## Tip: JPA

- Query kódkiegészítés
- Metódusnév kódkiegészítés
- JPA console
- JPABuddy
    - Flyway
    - Liquibase
- Spring Data JPA generált kód, AOT
    - Csak beteszi a mvn goal hívást a build elé

## Tip: Hibernate

- Debug módban kell indítani
- SQL, JPQL
- Console
- Transaction id

## Tip: Spring Security

- A api végpontok mellett megmutatja, milyen role-okkal lehet meghívni
- HTTP client-ben is! (unlock)
- User credentialt is meg lehet adni
- Navigate to security configuration
- Spring Debugger automatically injects a custom x-spring-debugger-security-decisions header into HTTP responses
- Security contextin debug

## Tip: Spring Modulith

## Tip: Database

- [Query execution plan](https://www.jetbrains.com/help/idea/query-execution-plan.html)
    - Enroll (futtatás console-ból, majd execution plan, )
- [Cross database queries](https://www.jetbrains.com/help/idea/cross-database-queries.html) (demó nélkül)

## Tip: Language injection

- `//language=JSON`

## Tip: HTTP client

- Kódkiegészítés
- Dynamic variables
- Környezetek
- Ciklus
    - Iterate over collections in variables

```
### Join loop
< {%
  request.variables.set("employees", [
      {"name": "John Doe"},
      {"name": "Jack Doe"},
      {"name": "Jane Doe"}
  ]);
%}

POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "name": "{{$.employees..name}}"
}

> {%
    let current = request.variables.get("employees")[request.iteration()];
    client.test(`Employee ${current.name} created`, () => {
        client.assert(response.status === 201, `Expected 201, got ${response.status}`);
        let name = jsonPath(response.body, "$.name");
        client.assert(name === current.name, `Expected ${current.name}, got ${name}`);
    });
%}
```

- Futtatás CLI-ből (demó nálkül)

## Tip: Endpoints

- OpenAPI
- Export draft, Swagger, Redocly

## Tip: Docker Compose

- Docker compose templates
- Log

## Tip: Git 
    
- Worktrees
    - AI-driven development

## Tip: Terminal

- Ctrl Space
- Terminal tabs in the editor

## Tip: Markdown

- Language injection
- Mermaid, PlantUML

## Tip: Profiler

- CPU and memory live charts
- Profiler
    - Flame Graph
- Heap dump

## Tip: AI

- Air
- Ctrl Ctrl
- Sessions

## Tip: Plugins

- Rainbow Brackets
- String Manipulation
- CodeGlance Pro
