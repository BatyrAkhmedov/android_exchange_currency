
# 📱 Currency Exchange App

An Android application for displaying up-to-date exchange rates and their changes over the last 24 hours.

---

## 🛠 Features

- Displays the exchange rate of popular currencies against the euro.
- Shows how the exchange rate has changed over the past 24 hours.
- Refresh button to manually update data.
- Animations for loading indicator (ProgressBar).

---

## 🧱 Architecture & Stack

- **MVVM** architecture
- **Kotlin**
- **Coroutines** for asynchronous operations
- **LiveData** for UI updates
- **Retrofit** for network requests
- **ViewBinding**
- **Modularization** (presentation / domain / data)

---

## 📦 Modules

- `currency_lib`: Domain and data logic
- `presentation`: UI layer and ViewModels
- `data`: Repository, remote data source, mappers

---

## 📈 Example

| Feature        | Description                                  |
|----------------|----------------------------------------------|
| Currency List  | Shows currencies and their rates             |
| Color Indication | Green for increase, red for decrease, white for unchanged |
| ProgressBar    | Appears/disappears with animation while loading |

---

## 🔗 API Source

- [Exchange Rates API](https://exchangeratesapi.io/) (uses the timeseries endpoint for changes)

---

## 🚀 Getting Started

1. Clone the repository
2. Replace the `ACCESS_KEY` in `ExchangeApiService` with your personal API key
3. Build and run the application on an emulator or Android device

---

## 📂 Project Structure (Simplified)

```
📁 com.example.currency
 ┣ 📁 presentation
 ┃ ┣ 📁 recycler_view
 ┃ ┣ 📁 model
 ┃ ┣ 📁 mapper
 ┃ ┗ 📜 CurrencyListFragment.kt
 ┣ 📁 data
 ┃ ┣ 📁 data_source
 ┃ ┣ 📁 mapper
 ┃ ┣ 📁 model
 ┃ ┣ 📁 repository
 ┃ ┗ 📁 retrofit
 ┣ 📁 domain
 ┃ ┣ 📁 model
 ┃ ┣ 📁 repository
 ┃ ┣ 📁 usecase
 ┃ ┗ 📁 util
```
