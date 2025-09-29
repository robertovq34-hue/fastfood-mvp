# FastFood MVP (Java) - Proyecto para la entrega

Repositorio de ejemplo que implementa un MVP mínimo usando **Factory**, **Builder** y **MVC**
para la creación y personalización de combos (hamburguesa/pollo/vegetariano).

## Estructura del proyecto
- `pom.xml` - proyecto Maven.
- `src/main/java/com/usil/fastfood/...` - código fuente.
- `diagram.mmd` - diagrama de clases en Mermaid.
- `run.sh` - script para compilar y ejecutar (Unix).

## Diagrama de clases (Mermaid)
```mermaid
classDiagram
    direction TB
    enum ComboType {
        HAMBURGUESA
        POLLO
        VEGETARIANO
    }

    class Combo {
        - ComboType tipo
        - String bebida
        - String acompanamiento
        - String extra
        - double precio
        + getResumen():String
    }

    class ComboBuilder {
        - Combo combo
        + ComboBuilder(ComboType tipo)
        + setBebida(String):ComboBuilder
        + setAcompanamiento(String):ComboBuilder
        + setExtra(String):ComboBuilder
        + setPrecio(double):ComboBuilder
        + build():Combo
    }

    class ComboFactory {
        + crearComboBase(ComboType):Combo
    }

    class ComboController {
        - ComboFactory factory
        + crearYPersonalizar(ComboType, String bebida, String acomp, String extra):Combo
    }

    class ComboView {
        + mostrarResumen(Combo):void
        + pedirPersonalizacion():void
    }

    Combo --> ComboBuilder : built by
    ComboFactory --> Combo : crea instancia base
    ComboController --> ComboFactory : usa
    ComboController --> Combo : devuelve
    ComboView --> ComboController : interactua con
```

## Cómo compilar y ejecutar (Maven)
```bash
mvn package
java -cp target/fastfood-mvp-1.0-SNAPSHOT.jar com.usil.fastfood.Main
```

O con `run.sh`:
```bash
chmod +x run.sh
./run.sh
```

## Plan de commits sugerido (mensajes)
1. `init: crear proyecto base y estructura de paquetes`
2. `feat(model): implementar clase Combo y ComboType`
3. `feat(builder): añadir ComboBuilder`
4. `feat(factory): implementar ComboFactory con combos base`
5. `feat(mvc): agregar ComboController y ComboView (consola)`
6. `docs: agregar diagrama de clases y README`
7. `fix: correccion menor en validaciones`

## Qué llevar a la revisión en clase
- Mostrar `git log --oneline` con al menos 5 commits.
- Abrir diagrama y explicar responsabilidades de las clases.
- Ejecutar `Main` y personalizar un combo en vivo.
