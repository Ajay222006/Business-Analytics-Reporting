# Business Analytics Reporting System

A moderate-level Java project with JUnit tests, Docker, Jenkins CI/CD, and Kubernetes deployment.

---

## Project Structure

```
business-analytics-reporting/
├── src/
│   ├── main/java/com/analytics/
│   │   ├── Main.java               ← Entry point
│   │   ├── SalesData.java          ← Data model
│   │   ├── AnalyticsService.java   ← Core logic
│   │   ├── ReportService.java      ← Report builder
│   │   └── Report.java             ← Report model
│   └── test/java/com/analytics/
│       ├── AnalyticsServiceTest.java
│       └── ReportServiceTest.java
├── k8s/
│   ├── deployment.yaml
│   └── service.yaml
├── Dockerfile
├── Jenkinsfile
└── pom.xml
```

---

## Step 1 — Build Locally

```bash
cd business-analytics-reporting
mvn clean package
java -jar target/business-analytics-reporting-1.0.0.jar
```

## Step 2 — Run Tests

```bash
mvn test
```

## Step 3 — Push to GitHub

```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/YOUR_USERNAME/business-analytics-reporting.git
git push -u origin main
```

## Step 4 — Jenkins Setup

1. Install Jenkins → go to http://localhost:8080
2. Install plugins: Git, Pipeline, Docker Pipeline
3. Add credentials:
   - ID: `dockerhub-credentials` → your DockerHub username + password
4. New Item → Pipeline → name it `analytics-pipeline`
5. Pipeline script: choose "Pipeline script from SCM"
6. SCM: Git → paste your GitHub repo URL
7. Script Path: `Jenkinsfile`
8. Replace in Jenkinsfile:
   - `YOUR_DOCKERHUB_USERNAME` → your DockerHub username
   - `YOUR_GITHUB_USERNAME`   → your GitHub username

## Step 5 — Build Pipeline

Click **Build Now** in Jenkins. It will:
- Clone your repo
- Build with Maven
- Run JUnit tests
- Build Docker image
- Push to DockerHub
- Deploy to Kubernetes

## Step 6 — Kubernetes Deploy

```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl get pods
kubectl get svc
```

---

## Replace Before Use

| Placeholder                  | Replace With              |
|------------------------------|---------------------------|
| YOUR_DOCKERHUB_USERNAME      | Your DockerHub username   |
| YOUR_GITHUB_USERNAME         | Your GitHub username      |
