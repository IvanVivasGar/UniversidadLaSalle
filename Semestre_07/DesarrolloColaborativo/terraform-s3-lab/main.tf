# ==========================================
# CONFIGURACIÓN DEL PROVIDER AWS
# ==========================================
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
  required_version = ">= 1.0"
}

provider "aws" {
  region = "us-east-1" # Sujeto a cambios, depende de mi

  # Opcional: Si necesitas configurar credenciales aquí
  # access_key = "AKIAYWJHBM7DENER6GX2"
  # secret_key = "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"
}

# ==========================================
# CREACIÓN DEL BUCKET S3
# ==========================================
resource "aws_s3_bucket" "mi_bucket" {
  # IMPORTANTE: Cambia "tunombre" por tu nombre real
  # Ejemplo: s3-juan-1234, s3-maria-5678, etc.
  # El nombre debe ser único globalmente en AWS
  bucket = "s3-ivan77850-${random_integer.suffix.result}"

  tags = {
    Name        = "Bucket-Terraform-Lab"
    Environment = "Development"
    ManagedBy   = "Terraform"
    Owner       = "ivan"
  }
}

# Generar sufijo aleatorio para nombre único
resource "random_integer" "suffix" {
  min = 1000
  max = 9999
}

# ==========================================
# CONFIGURACIONES DE SEGURIDAD
# ==========================================

# Bloquear acceso público al bucket
resource "aws_s3_bucket_public_access_block" "mi_bucket_pab" {
  bucket = aws_s3_bucket.mi_bucket.id

  block_public_acls       = true
  block_public_policy     = true
  ignore_public_acls      = true
  restrict_public_buckets = true
}

# Habilitar versionado
resource "aws_s3_bucket_versioning" "mi_bucket_versioning" {
  bucket = aws_s3_bucket.mi_bucket.id

  versioning_configuration {
    status = "Enabled"
  }
}

# Habilitar cifrado por defecto
resource "aws_s3_bucket_server_side_encryption_configuration" "mi_bucket_encryption" {
  bucket = aws_s3_bucket.mi_bucket.id

  rule {
    apply_server_side_encryption_by_default {
      sse_algorithm = "AES256"
    }
  }
}

# ==========================================
# OUTPUTS - INFORMACIÓN DE SALIDA
# ==========================================
output "bucket_name" {
  description = "Nombre del bucket S3 creado"
  value       = aws_s3_bucket.mi_bucket.id
}

output "bucket_arn" {
  description = "ARN del bucket S3"
  value       = aws_s3_bucket.mi_bucket.arn
}

output "bucket_region" {
  description = "Región del bucket"
  value       = aws_s3_bucket.mi_bucket.region
}