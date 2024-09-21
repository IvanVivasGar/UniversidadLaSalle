import os
import subprocess
import sys

# Nombre del entorno virtual
venv_name = 'MPIv_env_Win'

# Crear el entorno virtual
subprocess.run([sys.executable, '-m', 'venv', venv_name])

# Activar el entorno virtual
activate_script = os.path.join(venv_name, 'Scripts', 'activate.bat')
subprocess.run(activate_script, shell=True)

# Instalar las dependencias necesarias
subprocess.run([sys.executable, '-m', 'pip', 'install', 'matplotlib', 'scikit-image', 'numpy'])