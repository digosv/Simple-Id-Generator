import { useState } from "react";
import { Link } from "lucide-react";
import "./App.css";

function App() {
  const [size, setSize] = useState(6);
  const [shortID, setShortId] = useState("");

  const handlGenerate = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/generate?size=${size}`
      );
      const text = await response.text();
      setShortId(text);
    } catch (error) {
      console.log("Erro ao Gerar ID:", error);
    }
  };

  return (
    <div className="app-container">
      <header className="header">
        <div className="h1-link">
          <Link className="link" />
          <h1>Simple ID Generator</h1>
        </div>
        <h3>Uma API simples e rápida para gerar IDs únicos </h3>
      </header>
      <div className="containersup">
        <div className="container">
          <p>
            <label htmlFor="">Simple ID Generator</label> é uma API simples para
            geração de IDs. Há uma probabilidade de IDs duplicados mas ela é
            extremamente baixa.
          </p>
          <p>O tamanho do ID pode ser modificado pelo usuario da API</p>
        </div>
        <div className="controls">
          <label className="sizeid" htmlFor="size">
            Tamanho do ID:
            <p className="p">{size}</p>
          </label>
          <input
            className="input"
            type="range"
            value={size}
            min="1"
            max="36"
            id="size"
            onChange={(e) => setSize(Number(e.target.value))}
          />
          <button className="button" onClick={handlGenerate}>
            Gerar
          </button>
        </div>
        {shortID && (
          <div className="result">
            <p>ID Gerado:</p>
            <code>{shortID}</code>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
