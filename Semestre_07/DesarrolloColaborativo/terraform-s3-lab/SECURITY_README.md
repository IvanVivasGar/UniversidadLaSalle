# Seguridad y cómo limpiar secretos en el repositorio

Este archivo describe pasos rápidos para evitar publicar información sensible (credenciales AWS, estados de Terraform, llaves privadas) y cómo limpiar el historial si ya se subieron.

Qué ignoramos (ya agregado en `.gitignore`):

- Directorios `.terraform/` y `*.tfstate` (estados de Terraform)
- Archivos `*.tfvars` (pueden contener variables con secretos)
- Archivos y carpetas de AWS (`~/.aws/`, `credentials`, `config`)
- Llaves privadas `*.pem`, `secret-*.key`
- Archivos de entorno `.env`

Si ya se subieron secretos al repositorio:

1) Elimina los archivos y actualiza el índice de Git (ejecutar en la raíz del repo):

   git rm --cached path/to/secret.file

2) Haz un commit que elimine los archivos:

   git commit -m "Remove sensitive files"

3) Para eliminar secretos del historial (opción segura): usar la herramienta `git filter-repo` (recomendado) o `git filter-branch` (antiguo y lento). Ejemplo con `git filter-repo`:

   # Instala git-filter-repo (si no lo tienes)
   pip install --user git-filter-repo

   # Reescribe el historial eliminando el archivo indicado
   git filter-repo --path path/to/secret.file --invert-paths

4) Fuerza el push al repositorio remoto (ADVERTENCIA: reescribe historial):

   git push --force origin main

5) Rota las claves y credenciales que puedan haberse expuesto (por ejemplo, crea nuevas claves de acceso en AWS y revoca las anteriores).

Notas y recomendaciones:

- Nunca guardes credenciales en código fuente.
- Usa un backend remoto para el estado de Terraform (S3 con bloqueo via DynamoDB) y configura cifrado.
- Usa servicios de secretos (AWS Secrets Manager, HashiCorp Vault) para variables sensibles.
