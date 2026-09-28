-- Script para crear tabla de usuarios con autenticación (PostgreSQL)

-- Tabla de Usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(100) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(150),
    activo BOOLEAN DEFAULT true,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultimo_login TIMESTAMP NULL
);

-- Insertar usuario admin por defecto
-- Usuario: admin
-- Contraseña: admin123 (texto plano)
-- IMPORTANTE: Cambiar esta contraseña en producción
INSERT INTO usuarios (nombre_usuario, correo, contrasena, nombre_completo, activo)
SELECT 'admin', 'admin@sistema.local', 'admin123', 'Administrador', true
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE nombre_usuario = 'admin');

-- Índices para optimizar búsquedas
CREATE INDEX IF NOT EXISTS idx_usuarios_nombre_usuario ON usuarios(nombre_usuario);
CREATE INDEX IF NOT EXISTS idx_usuarios_correo ON usuarios(correo);
CREATE INDEX IF NOT EXISTS idx_usuarios_activo ON usuarios(activo);