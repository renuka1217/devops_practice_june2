#!/bin/bash

set -e

echo "[+] Deploy script started..."

# Navigate to your project directory (adjust path if needed)
cd /home/renuka

echo "[+] Stopping and removing existing containers..."
docker-compose down

echo "[+] Starting fresh containers with docker-compose..."
docker-compose up -d --build

echo "[+] Deployment complete!"
